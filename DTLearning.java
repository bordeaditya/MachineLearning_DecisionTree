import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


class TreeNode
{
	
	String attribute;
	int nodeNumber = 1;

	static int count = 0;

	TreeNode childValue0;
	TreeNode childValue1;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int getNodeNumber() {
		return nodeNumber;
	}

	public void setNodeNumber(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}

	
	public TreeNode(String attribute,TreeNode child0Node,TreeNode child1Node) {
		this.attribute = attribute;
		this.childValue0 = child0Node;
		this.childValue1 = child1Node;
		// Not a leaf Node
		if(!attribute.equalsIgnoreCase("0") && !attribute.equalsIgnoreCase("1"))
		{
			count++;
			this.nodeNumber = count;
		}
		else// Leaf Node
			this.nodeNumber = -1;
	}
		
	public TreeNode getChildValue0() {
		return childValue0;
	}

	public void setChildValue0(TreeNode childValue0) {
		this.childValue0 = childValue0;
	}

	public TreeNode getChildValue1() {
		return childValue1;
	}

	public void setChildValue1(TreeNode childValue1) {
		this.childValue1 = childValue1;
	}

	@Override
	public String toString() {
		return "TreeNode [attribute=" + attribute + "]";
	}

}

class Pairs
{
	int attributeValue;
	int classValue;
	
	public Pairs(int attributeValue, int classValue) {
		this.attributeValue = attributeValue;
		this.classValue = classValue;
	}

	public int getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(int attributeValue) {
		this.attributeValue = attributeValue;
	}

	public int getClassValue() {
		return classValue;
	}

	public void setClassValue(int classValue) {
		this.classValue = classValue;
	}
	
	
}

class Attributes
{
	String Name;
	boolean isUsed;
	ArrayList<Pairs> keyValues = new ArrayList<Pairs>(); 
	
	public String getName() {
		return Name;
	}
	public ArrayList<Pairs> getKeyValues() {
		return keyValues;
	}
	public void setKeyValues(ArrayList<Pairs> keyValues) {
		this.keyValues = keyValues;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
}

class InputData
{
	int XB,XC,XD,XE,XF,XG,ClassVal,XH,XI,XJ,XK,XL,XM,XN,XO,XP,XQ,XR,XS,XT,XU;
	
	public int getXB() {
		return XB;
	}

	public void setXB(int xB) {
		XB = xB;
	}

	public int getXC() {
		return XC;
	}

	public void setXC(int xC) {
		XC = xC;
	}

	public int getXD() {
		return XD;
	}

	public void setXD(int xD) {
		XD = xD;
	}

	public int getXE() {
		return XE;
	}

	public void setXE(int xE) {
		XE = xE;
	}

	public int getXF() {
		return XF;
	}

	public void setXF(int xF) {
		XF = xF;
	}

	public int getXG() {
		return XG;
	}

	public void setXG(int xG) {
		XG = xG;
	}
	
	public int getXH() {
		return XH;
	}

	public void setXH(int xH) {
		XH = xH;
	}

	public int getXI() {
		return XI;
	}

	public void setXI(int xI) {
		XI = xI;
	}

	public int getXJ() {
		return XJ;
	}

	public void setXJ(int xJ) {
		XJ = xJ;
	}

	public int getXK() {
		return XK;
	}

	public void setXK(int xK) {
		XK = xK;
	}

	public int getXL() {
		return XL;
	}

	public void setXL(int xL) {
		XL = xL;
	}

	public int getXM() {
		return XM;
	}

	public void setXM(int xM) {
		XM = xM;
	}

	public int getXN() {
		return XN;
	}

	public void setXN(int xN) {
		XN = xN;
	}

	public int getXO() {
		return XO;
	}

	public void setXO(int xO) {
		XO = xO;
	}

	public int getXP() {
		return XP;
	}

	public void setXP(int xP) {
		XP = xP;
	}

	public int getXQ() {
		return XQ;
	}

	public void setXQ(int xQ) {
		XQ = xQ;
	}

	public int getXR() {
		return XR;
	}

	public void setXR(int xR) {
		XR = xR;
	}

	public int getXS() {
		return XS;
	}

	public void setXS(int xS) {
		XS = xS;
	}

	public int getXT() {
		return XT;
	}

	public void setXT(int xT) {
		XT = xT;
	}

	public int getXU() {
		return XU;
	}

	public void setXU(int xU) {
		XU = xU;
	}
	
	public int getClassVal() {
		return ClassVal;
	}

	public void setClassVal(int classVal) {
		ClassVal = classVal;
	}
	
}

public class DTLearning {

	TreeNode root;
	static int i;
	static int NumberOfNodes = 0;
	int count = 0;
	boolean fillHashMap = false;
	
	// Fill Hash map with Majority and TreeNode
	HashMap<String,String> mapNodeValue = new HashMap<String, String>();
	
	// List to store the data sets.
	ArrayList<InputData> testSet = new ArrayList<InputData>();
	ArrayList<InputData> trainingSet = new ArrayList<InputData>();
	ArrayList<InputData> validationSet = new ArrayList<InputData>();
	
	// List of Attributes
	ArrayList<Attributes> attributeList = new ArrayList<Attributes>();
	
	String[] attributesArray;
	// program input
	int L,K;
	
	// To print 
	String toPrint;
	
	// File paths
	String pathTrainingSet,pathTestSet,pathValidationSet;
	
	public static void main(String[] args) {
		DTLearning classVars = new DTLearning();
		classVars.L = Integer.parseInt(args[0]);
		classVars.K = Integer.parseInt(args[1]);
		classVars.pathTrainingSet = args[2];
		classVars.pathValidationSet = args[3];
		classVars.pathTestSet = args[4];
		classVars.toPrint = args[5];
		
		// Read the file Data and Fill the lists:
		classVars.ReadInputFile(classVars.pathTrainingSet, classVars.trainingSet,true);
		
		classVars.ReadInputFile(classVars.pathTestSet, classVars.testSet,false);
		
		classVars.ReadInputFile(classVars.pathValidationSet, classVars.validationSet,false);
		
		TreeNode root = null, rootVI = null, rootIGPruned = null, rootVIPruned = null;		 
		try {
			// Information Gain Heuristic
			root = classVars.BuildDecisionTree(classVars.trainingSet, new ArrayList<String>(),false);
			
			// Variance Impurity Heuristic
			rootVI = classVars.BuildDecisionTree(classVars.trainingSet, new ArrayList<String>(),true);
			
			// Information Gain Heuristic - Post Pruned
			rootIGPruned = classVars.BuildPostPrunedDecisionTree(classVars.trainingSet,new ArrayList<String>(),false,classVars.validationSet,classVars.L,classVars.K);
			
			// Variance Impurity Heuristic - Post Pruned
			rootVIPruned = classVars.BuildPostPrunedDecisionTree(classVars.trainingSet,new ArrayList<String>(),true,classVars.validationSet,classVars.L,classVars.K);
						
			
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		double accuracyInformation = 0,accuracyVariance = 0,accuracyIGPostPruned =0,accuracyVIPostPruned = 0;
		
		
		try {
		
		// Accuracy of Information Gain Heuristic
		accuracyInformation = classVars.CalculateAccuracy(classVars.testSet, root);
		System.out.println("\n ** Information Gain Heuristic Accuracy = "+ accuracyInformation + "%");
		
		// Accuracy of Variance Impurity Heuristic
		accuracyVariance = classVars.CalculateAccuracy(classVars.testSet, rootVI);
		System.out.println("\n ** Variance Impurity Heuristic Accuracy = "+ accuracyVariance + "%");
		
		// Accuracy of Information Gain Heuristic - Post Pruning
		System.out.println(" \n ---- Post Pruning :--- ");
		accuracyIGPostPruned = classVars.CalculateAccuracy(classVars.testSet, rootIGPruned);
		System.out.println("\n ** Information Gain Heuristic Accuracy After Pruning = "+ accuracyIGPostPruned + "%");

		// Accuracy of Information Gain Heuristic - Post Pruning
		accuracyVIPostPruned = classVars.CalculateAccuracy(classVars.testSet, rootVIPruned);
		System.out.println("\n ** Variance Impurity Heuristic Accuracy After Pruning = "+ accuracyVIPostPruned + "%");

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}	
		
		// Print the decision Tree:
		if(classVars.toPrint.equalsIgnoreCase("yes"))
		{
			System.out.println("\nInformation Gain Heuristic Tree:");
			classVars.PrintDecisionTree(root,"");
			
			System.out.println("\n\nVariance Impurity Heuristic Tree:");
			classVars.PrintDecisionTree(rootVI,"");
			
			System.out.println("\nInformation Gain Heuristic Post Pruned Tree:");
			classVars.PrintDecisionTree(rootIGPruned,"");
			
			System.out.println("\n\nVariance Impurity Heuristic Post Pruned Tree:");
			classVars.PrintDecisionTree(rootVIPruned,"");
		}
		
	}
	
	// Build Post pruned decision tree
	public TreeNode BuildPostPrunedDecisionTree(ArrayList<InputData> trainingSubSet, ArrayList<String> usedAttr,
			boolean isVI, ArrayList<InputData> validationSet, int L, int K) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		fillHashMap = true;// Set Hash Map Filler True
		mapNodeValue.clear();
		TreeNode treeD = BuildDecisionTree(trainingSubSet, usedAttr, isVI);
		fillHashMap = false;
		
		TreeNode treeDBest = treeD;
		double accuracy_DBest = CalculateAccuracy(validationSet, treeDBest);
		for(int i=0;i<L;i++)
		{
			double accuracy_DDash = 0;
			TreeNode treeD_Dash = copyTree(treeD);
			//TreeNode treeD_Dash = copyTree(treeDBest);
			int M = GetRandomInteger(1, K);
			for(int j=0;j<M;j++)
			{
				DTLearning.NumberOfNodes = 0;
				NumberTreeNode(treeD_Dash);
				int N_nonLeaf = DTLearning.NumberOfNodes;
				if(N_nonLeaf != 0)
				{
					int P_randNo = GetRandomInteger(1, N_nonLeaf);
					RaplaceNodeByLeaf(treeD_Dash,P_randNo);
				}
				else
				{
					break;
				}
			}
			accuracy_DDash = CalculateAccuracy(validationSet, treeD_Dash);
			if(Double.compare(accuracy_DDash, accuracy_DBest) > 0)
			{
				accuracy_DBest = accuracy_DDash;
				treeDBest = treeD_Dash;
			}			
		}
		return treeDBest;
	}
	
	// Ordering of Tree Nodes
	public void NumberTreeNode(TreeNode treeNode) {
		
		if(treeNode!= null)
		{
			// if node is not a leaf
			if(!treeNode.getAttribute().equalsIgnoreCase("0") && !treeNode.getAttribute().equalsIgnoreCase("1"))
			{
				DTLearning.NumberOfNodes++;
				treeNode.setNodeNumber(DTLearning.NumberOfNodes);
				NumberTreeNode(treeNode.childValue0);
				NumberTreeNode(treeNode.childValue1);
			}
			else
			{
				treeNode.setNodeNumber(-1);
			}
		}
	}

	// Replace Node to leaf
	public void RaplaceNodeByLeaf(TreeNode treeNode, int p_randNo) {
		
		if(treeNode!=null)
		{
			if(treeNode.getNodeNumber()== p_randNo)
			{ 
				String majorValue = mapNodeValue.get(treeNode.attribute);
				// make tree as leaf node
				treeNode.setAttribute(majorValue);
				// set node as root
				treeNode.setNodeNumber(-1);
				treeNode.childValue0 = null;
				treeNode.childValue1 = null;
			}
			else
			{
				RaplaceNodeByLeaf(treeNode.childValue0,p_randNo);
				RaplaceNodeByLeaf(treeNode.childValue1,p_randNo);
			}
		}
	}

	// Copy the Decision Tree
	public TreeNode copyTree(TreeNode node){
		
		TreeNode temp = null;
		if(node != null)
		{
			if(!node.getAttribute().equalsIgnoreCase("0") && !node.getAttribute().equalsIgnoreCase("1"))
			{
				temp = new TreeNode(node.getAttribute(),node.childValue0,node.childValue1);
				temp.childValue0 = copyTree(node.childValue0);
				temp.childValue1 = copyTree(node.childValue1);
			}
			else
			{
				temp = new TreeNode(node.getAttribute(),null,null);
				temp.setNodeNumber(node.getNodeNumber());
			}
		}
		return temp;
	}

	// Generate Random variable
	public static int GetRandomInteger(int min, int max) {
	    
		Random randomValue = new Random();
	    int generatedRandomNum = randomValue.nextInt((max - min) + 1) + min;
	    return generatedRandomNum;
	}
	
	// Calculate Accuracy
	public double CalculateAccuracy(ArrayList<InputData> testSet,
			TreeNode root) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int testSize = testSet.size();
		int matchedClass = 0;
		double accuracy = 0,percentAccuracy = 0;
		TreeNode currentNode = root;
		Class<InputData> refectedClass = InputData.class;
		try
		{
			for(InputData test: testSet)
			{
				currentNode = root;
				// If node is not a LEAF
				while(!currentNode.getAttribute().equalsIgnoreCase("0") && !currentNode.getAttribute().equalsIgnoreCase("1"))
				{
					String getterName = "get" + currentNode.getAttribute();  	
					Method method = refectedClass.getMethod(getterName);
					int value = (int)method.invoke(test);

					if(value == 0 && currentNode.childValue0!= null)
						currentNode = currentNode.childValue0;
					else if(currentNode.childValue1!= null)
						currentNode = currentNode.childValue1;
				}
				
				String currentRecordClass = Integer.toString(test.getClassVal());
				if(currentNode.getAttribute().equalsIgnoreCase(currentRecordClass))
					matchedClass ++;
			}
			
		}
		catch(NullPointerException e){
			System.out.println("\n****EXCEPTION****"+e.getMessage());
		}
		accuracy = ((double)matchedClass/testSize);
		//System.out.println(" Matched "+ matchedClass);
		percentAccuracy = accuracy * 100;
		return percentAccuracy;
	}


	// Print the decision Tree
	public void PrintDecisionTree(TreeNode node, String tab) {

		if(node!= null)
		{
			//System.out.print(node.getNodeNumber());
			String startChar = " | ";
			if(node.getAttribute().equalsIgnoreCase("0") || node.getAttribute().equalsIgnoreCase("1"))
				System.out.print(" : " + node.getAttribute());
			else
			{
				System.out.print("\n"+ tab + node.getAttribute() + " = 0");
				PrintDecisionTree(node.childValue0,tab + startChar);
				System.out.print("\n"+ tab +node.getAttribute() + " = 1");
				PrintDecisionTree(node.childValue1,tab + startChar);
			}
		}
		
	}

	// Build the Decision Tree - Information Gain Heuristic isVariance= false / Variance Impurity Heuristic - isVariance= true
	public TreeNode BuildDecisionTree(ArrayList<InputData> trainingSet,ArrayList<String> usedAttributes,boolean isVariance) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		ArrayList<InputData> s0DataSet,s1DataSet;
		s0DataSet = new ArrayList<InputData>();
		s1DataSet = new ArrayList<InputData>();
		
		String nextAttribute = "";
		Class<InputData> refectedClass = InputData.class; 
		
		int y0 = 0, y1 = 0;
		for(InputData inputData:trainingSet)
		{
			if(inputData.getClassVal() == 0)
				y0++;
			else if(inputData.getClassVal() == 1)
				y1++;
			
		}
		
		// If the node is Leaf
		if(trainingSet.size() == y0)
		{
			return new TreeNode("0",null,null);
		}
		else if(trainingSet.size()== y1)
		{
			return new TreeNode("1",null,null);
		}
		else // If node is Not a leaf
		{
			if(!isVariance)
				nextAttribute = GetBestAttribute(trainingSet,usedAttributes);
			else
				nextAttribute = GetBestAttributeUsingVI(trainingSet,usedAttributes);
			
			if(!nextAttribute.equalsIgnoreCase("0") && !nextAttribute.equalsIgnoreCase("1"))
			{	
				// Select the best Attribute to bifurcate the data set
				String getterName = "get" + nextAttribute;  	
				Method method = refectedClass.getMethod(getterName);
				
				for(InputData input:trainingSet)
				{
					int value = (int)method.invoke(input);
					
					if(value == 0)
					{
						s0DataSet.add(input);
					}
					else if(value == 1)
					{
						s1DataSet.add(input);
					}
				}
				// Fill hashMap to keep the track of best attribute at each level.
				if(fillHashMap)
				{
					if(s0DataSet.size()> s1DataSet.size())
						mapNodeValue.put(nextAttribute, "0");
					else
						mapNodeValue.put(nextAttribute, "1");
				}
				
				ArrayList<String> leftUsedList = new ArrayList<String>();
				ArrayList<String> rightUsedList = new ArrayList<String>();
				
				leftUsedList.addAll(usedAttributes);
				leftUsedList.add(nextAttribute);
				
				rightUsedList.addAll(usedAttributes);
				rightUsedList.add(nextAttribute);
				
				// Return the node
				return new TreeNode(nextAttribute,BuildDecisionTree(s0DataSet,leftUsedList,isVariance),BuildDecisionTree(s1DataSet,rightUsedList,isVariance));
			}
			else
				return new TreeNode(nextAttribute,null,null);
		}
	}	

	// Choose the next best attribute for tree formation
	public String GetBestAttribute(ArrayList<InputData> trainingSubSet, ArrayList<String> usedAttributes) {
		
		String bestAttribute ="";
		// If data available
		if(trainingSubSet.size()!=0)
		{
			int positiveExampleCount = 0,negativeExampleCount =0;
			double attrEntropy = 0,child0Entropy =0 ,child1Entropy =0 ,maxGain = 0;
			// Fill the attribute set data
			FillAttributeData(trainingSubSet);
			
			// Calculating total Impurity in the remaining set
			for(InputData tempData:trainingSubSet)
			{
				if(tempData.getClassVal() == 1)
					positiveExampleCount++;
				else if(tempData.getClassVal() == 0)
					negativeExampleCount++;
			}
			// Calculate Entropy of Subset
			if(negativeExampleCount !=0 && positiveExampleCount !=0)
				attrEntropy = CalculateEntropy(negativeExampleCount,positiveExampleCount);
			
			int zeroExFor0Child,zeroExFor1Child,totalCount = 0, oneExFor0Child =0, oneExFor1Child =0;
			
			// Iterate over each attribute to select attribute having best gain value 
			for(Attributes attr: attributeList)
			{
				child0Entropy = 0; child1Entropy = 0;
				zeroExFor0Child =0 ; zeroExFor1Child = 0; oneExFor0Child =0; oneExFor1Child =0;
				// If Attribute is not used.(isUsed == FALSE)
				if(!usedAttributes.contains(attr.getName()))
				{
					// Every Pairs 
					for(Pairs inputTempPair: attr.getKeyValues())
					{
						totalCount = attr.getKeyValues().size();
						// Calculate Count for number of zero/One class value examples 
						if(inputTempPair.getAttributeValue() == 0 && inputTempPair.getClassValue()==0)
							zeroExFor0Child++;
						if(inputTempPair.getAttributeValue() == 0 && inputTempPair.getClassValue()==1)
							oneExFor0Child++;
						if(inputTempPair.getAttributeValue() == 1 && inputTempPair.getClassValue()==0)
							zeroExFor1Child++;
						if(inputTempPair.getAttributeValue() == 1 && inputTempPair.getClassValue()==1)
							oneExFor1Child++;
					 }
				
					// Calculate Entropy from received counts
					// Entropy of Child 0
					if(zeroExFor0Child !=0 && oneExFor0Child !=0)
						child0Entropy = CalculateEntropy(zeroExFor0Child, oneExFor0Child);
					
					// Entropy of Child 1
					if(zeroExFor1Child !=0 && oneExFor1Child !=0)
						child1Entropy = CalculateEntropy(zeroExFor1Child, oneExFor1Child);
					
					// Calculate gain of current attribute.
					double newGain = CalculateGain(attrEntropy,child0Entropy,child1Entropy,(zeroExFor0Child + oneExFor0Child),totalCount);
					
					// If new Gain is Greater than MAX
					if(Double.compare(newGain,maxGain) > 0)
					{
						bestAttribute = "";
						bestAttribute = attr.getName();
						// update Gain and attribute
						maxGain = newGain;
					 }
				}
			}
		}
		
		if(bestAttribute.equalsIgnoreCase(""))
			bestAttribute = "1";
		
		return bestAttribute;
	}

	// Calculate Gain : Information Gain Heuristic
	public double CalculateGain(double attrEntropy, double child0Entropy,
			double child1Entropy, int child0Exmples, int totalCount) 
	{
		int child1Examples = totalCount - child0Exmples;
		double gain = 0;
		double probOfZero = child0Entropy*((double)child0Exmples/totalCount);
		double probOfOne = child1Entropy*((double)child1Examples/totalCount);
		gain = attrEntropy - (probOfZero + probOfOne);
		return gain;
	}

	// Calculation of Entropy - Information Gain Heuristic
	public double CalculateEntropy(int negativeExampleCount,int positiveExampleCount) {
		int totalCount = positiveExampleCount+ negativeExampleCount;
		double doubleZero = 0,positiveEntropy = 0,negativeEntropy = 0;
		double positiveProbability = ((double)positiveExampleCount/totalCount);
		double negativeProbability = ((double)negativeExampleCount/totalCount);
		if(Double.compare(positiveProbability, doubleZero)!= 0)
			positiveEntropy = -(positiveProbability*(Math.log(positiveProbability) / Math.log(2)));
		
		if(Double.compare(negativeProbability, doubleZero)!= 0)
			negativeEntropy = -(negativeProbability*(Math.log(negativeProbability) / Math.log(2)));
			
		return (positiveEntropy + negativeEntropy);
	}

	
	// Get Best Attribute for Variance Impurity Heuristic
	public String GetBestAttributeUsingVI(ArrayList<InputData> trainingSubSet,
			ArrayList<String> usedAttributes) {
		String bestAttribute ="";
		// If data available
		if(trainingSubSet.size()!=0)
		{
			int positiveExampleCount = 0,negativeExampleCount =0;
			double attrVariance,child0Variance =0 ,child1Variance =0 ,maxGain = 0;
			// Fill the attribute set data
			FillAttributeData(trainingSubSet);
			
			// Calculating total Impurity in the remaining set
			for(InputData tempData:trainingSubSet)
			{
				if(tempData.getClassVal() == 1)
					positiveExampleCount++;
				else if(tempData.getClassVal() == 0)
					negativeExampleCount++;
			}
			
			// Calculate Entropy of Subset
			attrVariance = CalculateVarinceImpurity(negativeExampleCount,positiveExampleCount);
			
			int zeroExFor0Child,zeroExFor1Child,totalCount = 0, oneExFor0Child =0, oneExFor1Child =0;
			
			// Iterate over each attribute to select attribute having best gain value 
			for(Attributes attr: attributeList)
			{
				child0Variance =0 ; child1Variance =0 ;
				zeroExFor0Child =0 ; zeroExFor1Child = 0; oneExFor0Child =0; oneExFor1Child =0;
				// If Attribute is not used.(isUsed == FALSE)
				if(!usedAttributes.contains(attr.getName()))
				{
					// Every Pairs 
					for(Pairs inputTempPair: attr.getKeyValues())
					{
						totalCount = attr.getKeyValues().size();
						// Calculate Count for number of zero/One class value examples 
						if(inputTempPair.getAttributeValue() == 0 && inputTempPair.getClassValue()==0)
							zeroExFor0Child++;
						if(inputTempPair.getAttributeValue() == 0 && inputTempPair.getClassValue()==1)
							oneExFor0Child++;
						if(inputTempPair.getAttributeValue() == 1 && inputTempPair.getClassValue()==0)
							zeroExFor1Child++;
						if(inputTempPair.getAttributeValue() == 1 && inputTempPair.getClassValue()==1)
							oneExFor1Child++;
					 }
				
					// Calculate variance impurity from received counts
					// Variance Impurity of Child 0
					if(zeroExFor0Child !=0 && oneExFor0Child !=0)
						child0Variance = CalculateVarinceImpurity(zeroExFor0Child, oneExFor0Child);
					
					// Variance Impurity of Child 1
					if(zeroExFor1Child !=0 && oneExFor1Child !=0)
						child1Variance = CalculateVarinceImpurity(zeroExFor1Child, oneExFor1Child);
					
					// Calculate gain of current attribute.
					double newGain = CalculateGain(attrVariance,child0Variance,child1Variance,(zeroExFor0Child + oneExFor0Child),totalCount);
					
					// If new Gain is Greater than MAX
					if(Double.compare(newGain,maxGain)> 0)
					{
						bestAttribute = "";
						bestAttribute = attr.getName();
						// update Gain and attribute
						maxGain = newGain;
					 }
				}
			}
		}
		if(bestAttribute.equalsIgnoreCase(""))
			bestAttribute = "1";
		
		return bestAttribute;
	}
	
	// Calculate Variance Impurity
	public double CalculateVarinceImpurity(int negativeExampleCount,
			int positiveExampleCount) {
		
		int totalCount = positiveExampleCount + negativeExampleCount;
		double positiveProbability = ((double)positiveExampleCount/totalCount);
		double negativeProbability = ((double)negativeExampleCount/totalCount);
		double result = positiveProbability * negativeProbability;
		return result;
	}

	// Read the CSV data file
	public void ReadInputFile(String path,ArrayList<InputData> inputSet, boolean isTrainingSet)
	{
		BufferedReader br = null;
		String line = "";
		String delimiter =",";
		InputData inputFileData;
		try
		{
			
			// File path is entered.
			if(!path.trim().equals(""))
			{
				System.out.println("Reading the Input File Data");
				br = new BufferedReader(new FileReader(path));
				line = br.readLine();
				attributesArray = line.split(java.util.regex.Pattern.quote(delimiter));
				
				line = "";
				while ((line = br.readLine()) != null) 
				{ 
					inputFileData = new InputData();
					String[] singleRecord = line.split(java.util.regex.Pattern.quote(delimiter));
					inputFileData.setXB(Integer.parseInt(singleRecord[0]));
					inputFileData.setXC(Integer.parseInt(singleRecord[1]));
					inputFileData.setXD(Integer.parseInt(singleRecord[2]));
					inputFileData.setXE(Integer.parseInt(singleRecord[3]));
					inputFileData.setXF(Integer.parseInt(singleRecord[4]));
					inputFileData.setXG(Integer.parseInt(singleRecord[5]));
					
					inputFileData.setXH(Integer.parseInt(singleRecord[6]));
					inputFileData.setXI(Integer.parseInt(singleRecord[7]));
					inputFileData.setXJ(Integer.parseInt(singleRecord[8]));
					inputFileData.setXK(Integer.parseInt(singleRecord[9]));
					
					inputFileData.setXL(Integer.parseInt(singleRecord[10]));
					inputFileData.setXM(Integer.parseInt(singleRecord[11]));
					inputFileData.setXN(Integer.parseInt(singleRecord[12]));
					inputFileData.setXO(Integer.parseInt(singleRecord[13]));
					inputFileData.setXP(Integer.parseInt(singleRecord[14]));
					inputFileData.setXQ(Integer.parseInt(singleRecord[15]));
					inputFileData.setXR(Integer.parseInt(singleRecord[16]));
					inputFileData.setXS(Integer.parseInt(singleRecord[17]));
					inputFileData.setXT(Integer.parseInt(singleRecord[18]));
					inputFileData.setXU(Integer.parseInt(singleRecord[19]));
					inputFileData.setClassVal(Integer.parseInt(singleRecord[20]));
					//inputFileData.setClassVal(Integer.parseInt(singleRecord[10]));
					// add record to data set.
					inputSet.add(inputFileData);
				}
				if(isTrainingSet)
				{
					// Fill attributes:
					Attributes attributesData;
					for(int i=0;i<attributesArray.length;i++)
					{
						attributesData = new Attributes();
						attributesData.setName(attributesArray[i]);
						attributesData.setUsed(false);
						attributesData.keyValues = null;
						attributeList.add(attributesData);
					}
					// Remove class attribute
					attributeList.remove(attributeList.size()-1);
				}
				br.close();
			}	
		}
		catch(Exception ex)
		{
			System.out.println("Error Occured" + ex.getMessage());
		}
	}
	
	
	// Fill the Attribute Data Lists
	public void FillAttributeData(ArrayList<InputData> dataSet)
	{
		//Clear previous data:
		for(Attributes attributesData: attributeList)
		{
			if(attributesData.keyValues != null)
				attributesData.keyValues.clear();
			else
				attributesData.keyValues = new ArrayList<Pairs>();
		}
		
		// Fill Attributes Data
		for(InputData inputTemp:dataSet)
		{
			for(Attributes attributesData: attributeList)
			{
				if(attributesData.getName().equalsIgnoreCase("XB"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXB(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XC"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXC(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XD"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXD(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XE"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXE(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XF"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXF(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XG"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXG(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XH"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXH(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XI"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXI(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XJ"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXJ(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XK"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXK(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XL"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXL(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XM"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXM(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XN"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXN(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XO"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXO(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XP"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXP(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XQ"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXQ(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XR"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXR(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XS"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXS(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XT"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXT(), inputTemp.getClassVal()));
				else if(attributesData.getName().equalsIgnoreCase("XU"))
					attributesData.keyValues.add(new Pairs(inputTemp.getXU(), inputTemp.getClassVal()));
			}
			
		}
	}

}
