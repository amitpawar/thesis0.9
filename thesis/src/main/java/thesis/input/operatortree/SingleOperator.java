package thesis.input.operatortree;

import java.util.List;

import org.apache.flink.api.common.operators.Operator;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;

import thesis.algorithm.semantics.EquivalenceClass;

public class SingleOperator {
	
	private String name;
	private OperatorType operatorType;
	private String previousOperator;
	private OperatorType previousOperatorType;
	private TypeInformation<?> operatorOutputType;
	private List<TypeInformation<?>> operatorInputType;
	private JUCCondition jucCondition;
	private Operator<?> operator;
	private List<Integer> operatorInputDataSetId;
	private List<DataSet<?>> operatorDataSets;
	private DataSet<?> exampleTuples;
	private int[] projectColumns;
	private List<EquivalenceClass> equivalenceClasses;
	
	


	public List<EquivalenceClass> getEquivalenceClasses() {
		return equivalenceClasses;
	}

	public void setEquivalenceClasses(List<EquivalenceClass> equivalenceClasses) {
		this.equivalenceClasses = equivalenceClasses;
	}

	public int[] getProjectColumns() {
		return projectColumns;
	}

	public void setProjectColumns(int[] projectColumns) {
		this.projectColumns = projectColumns;
	}

	public DataSet<?> getExampleTuples() {
		return exampleTuples;
	}

	public void setExampleTuples(DataSet<?> exampleTuples) {
		this.exampleTuples = exampleTuples;
	}

	public List<DataSet<?>> getOperatorDataSets() {
		return operatorDataSets;
	}

	public void setOperatorDataSets(List<DataSet<?>> operatorDataSets) {
		this.operatorDataSets = operatorDataSets;
	}

	public List<Integer> getOperatorInputDataSetId() {
		return operatorInputDataSetId;
	}

	public void setOperatorInputDataSetId(List<Integer> operatorInputDataSetId) {
		this.operatorInputDataSetId = operatorInputDataSetId;
	}

	public Operator<?> getOperator() {
		return operator;
	}

	public void setOperator(Operator<?> operator) {
		this.operator = operator;
	}

	public JUCCondition getJUCCondition() {
		return jucCondition;
	}

	public void setJUCCondition(JUCCondition joinCondition) {
		this.jucCondition = joinCondition;
	}

	public List<TypeInformation<?>> getOperatorInputType() {
		return operatorInputType;
	}

	public void setOperatorInputType(List<TypeInformation<?>> operatorInputType) {
		this.operatorInputType = operatorInputType;
	}

	public TypeInformation<?> getOperatorOutputType() {
		return operatorOutputType;
	}

	public void setOperatorOutputType(TypeInformation<?> operatorOutputType) {
		this.operatorOutputType = operatorOutputType;
	}

	public String getOperatorName(){
		return this.name;
	}
	
	public void setOperatorName(String name){
		this.name = name;
	}
	
	public String getPreviousOperatorName(){
		return this.previousOperator;
	}
	
	public void setPreviousOperatorName(String name){
		this.previousOperator = name;
	}
	
	public OperatorType getOperatorType(){
		return this.operatorType;
	}
	
	public void setOperatorType(OperatorType type){
		this.operatorType = type;
	}
	
	public OperatorType getPreviousOperatorType(){
		return this.previousOperatorType;
	}
	
	public void setPreviousOperatorType(OperatorType type){
		this.previousOperatorType = type;
	}
	
	
	public class JUCCondition {
		private OperatorType operatorType;
		private int firstInput;
		private int secondInput;
		private int[] firstInputKeyColumns;
		private int[] secondInputKeyColumns;

		public OperatorType getOperatorType() {
			return operatorType;
		}

		public void setOperatorType(OperatorType operatorType) {
			this.operatorType = operatorType;
		}
		public int[] getFirstInputKeyColumns() {

			return firstInputKeyColumns;
		}
		public void setFirstInputKeyColumns(int[] firstInputKeyColumns) {

			this.firstInputKeyColumns = firstInputKeyColumns;
		}
		public int[] getSecondInputKeyColumns() {

			return secondInputKeyColumns;
		}
		public void setSecondInputKeyColumns(int[] secondInputKeyColumns) {
			this.secondInputKeyColumns = secondInputKeyColumns;
		}
	
		public int getFirstInput() {

			return firstInput;
		}
		public void setFirstInput(int firstInput) {
			this.firstInput = firstInput;
		}
		public int getSecondInput() {

			return secondInput;
		}
		public void setSecondInput(int secondInput) {

			this.secondInput = secondInput;
		}
	}

}


