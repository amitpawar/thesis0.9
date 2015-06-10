package thesis.examples;


import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.operators.TupleGenerator;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple4;
import thesis.input.operatortree.OperatorTree;
import thesis.examples.CrossExample.*;

public class FilterExample {

    public static void main(String[] args) throws Exception {

        ExecutionEnvironment env = ExecutionEnvironment.createCollectionsEnvironment();


        DataSource<String> input1 = env.readTextFile("src/resources/CrossInput1");
        DataSource<String> input2 = env.readTextFile("src/resources/CrossInput2");

        DataSet<Tuple2<Integer, String>> set1 = input1.flatMap(new OneReader());

        DataSet<Tuple2<Integer, Double>> set2 = input2.flatMap(new TwoReader());
        DataSet<Tuple2<Integer, Double>> filterSet = set2.filter(new PopulationFilter());

        DataSet<Tuple4<Integer,String,Integer,Double>> crossSet = set1.cross(filterSet).projectFirst(0)
                .projectFirst(1).projectSecond(0).projectSecond(1);

        crossSet.print();
        OperatorTree tree = new OperatorTree(env);
        TupleGenerator tg = new TupleGenerator(tree.createOperatorTree(),env,2);
        //env.execute();

    }

    public static class PopulationFilter
            implements
            FilterFunction<Tuple2<Integer, Double>> {


        public boolean filter(Tuple2<Integer, Double> value) throws Exception {
            return value.f1 > 40;
        }
    }
}
