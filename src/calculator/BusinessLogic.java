
package calculator;

/**
 * <p> Title: BusinessLogic Class. </p>
 * 
 * <p> Description: The code responsible for performing the calculator business logic functions. 
 * This method deals with CalculatorValues and performs actions on them. The class expects data
 * from the User Interface to arrive as Strings and returns Strings to it. This class calls the
 * CalculatorValue class to do computations and this class knows nothing about the actual 
 * representation of CalculatorValues, that is the responsibility of the CalculatorValue class and
 * the classes it calls.</p>
 * 
 * <p> Copyright: Lynn Robert Carter Â© 2017 </p>
 * 
 * @author Sparsh Goel
 * 
 * @version 4.03	2018-02-25 The JavaFX-based GUI implementation of a Double calculator 
 * 
 */

public class BusinessLogic {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	// These are the major calculator values 
	private CalculatorValue operand1MeasuredValue = new CalculatorValue(0);
	private CalculatorValue operand1ErrorTerm = new CalculatorValue(0);
	private CalculatorValue operand2MeasuredValue = new CalculatorValue(0);
	private CalculatorValue operand2ErrorTerm = new CalculatorValue(0);
	private CalculatorValue result = new CalculatorValue(0);
	private String operand1ErrorMessage = "";
	private boolean operand1Defined = false;
	private String operand2ErrorMessage = "";
	private boolean operand2Defined = false;
	private String resultErrorMessage = "";

	/**********************************************************************************************

	Constructors
	
	**********************************************************************************************/
	
	/**********
	 * This method initializes all of the elements of the business logic aspect of the calculator.
	 * There is no special computational initialization required, so the initialization of the
	 * attributes above are all that are needed.
	 */
	public BusinessLogic() {
	}

	/**********************************************************************************************

	Getters and Setters
	
	**********************************************************************************************/
	
	/**********
	 * This public method takes an input String, checks to see if there is a non-empty input string.
	 * If so, it places the converted CalculatorValue into operand1, any associated error message
	 * into operand1ErrorMessage, and sets flags accordingly.
	 * 
	 * @param value
	 * @return	True if the set did not generate an error; False if there was invalid input
	 */
	public boolean setOperand1MeasuredValue(String value) {
		operand1Defined = false;							// Assume the operand will not be defined
		if (value.length() <= 0) {						// See if the input is empty. If so no error
			operand1ErrorMessage = "";					// message, but the operand is not defined.
			return true;									// Return saying there was no error.
		}
		operand1MeasuredValue = new CalculatorValue(value);			// If there was input text, try to convert it
		operand1ErrorMessage = operand1MeasuredValue.getErrorMessage();	// into a CalculatorValue and see if it
		if (operand1ErrorMessage.length() > 0) 			// worked. If there is a non-empty error 
			return false;								// message, signal there was a problem.
		operand1Defined = true;							// Otherwise, set the defined flag and
		return true;										// signal that the set worked
	}
	
	public boolean setOperand1ErrorTerm(String value) {
		operand1Defined = false;							// Assume the operand will not be defined
		if (value.length() <= 0) {						// See if the input is empty. If so no error
			operand1ErrorMessage = "";					// message, but the operand is not defined.
			return true;									// Return saying there was no error.
		}
		operand1ErrorTerm = new CalculatorValue(value);			// If there was input text, try to convert it
		operand1ErrorMessage = operand1ErrorTerm.getErrorMessage();	// into a CalculatorValue and see if it
		if (operand1ErrorMessage.length() > 0) 			// worked. If there is a non-empty error 
			return false;								// message, signal there was a problem.
		operand1Defined = true;							// Otherwise, set the defined flag and
		return true;										// signal that the set worked
	}
	
	/**********
	 * This public method takes an input String, checks to see if there is a non-empty input string.
	 * If so, it places the converted CalculatorValue into operand2, any associated error message
	 * into operand1ErrorMessage, and sets flags accordingly.
	 * 
	 * The logic of this method is the same as that for operand1 above.
	 * 
	 * @param value
	 * @return	True if the set did not generate an error; False if there was invalid input
	 */
	public boolean setOperand2MeasuredValue(String value) {			// The logic of this method is exactly the
		operand2Defined = false;							// same as that for operand1, above.
		if (value.length() <= 0) {
			operand2ErrorMessage = "";
			return true;
		}
		operand2MeasuredValue = new CalculatorValue(value);
		operand2ErrorMessage = operand2MeasuredValue.getErrorMessage();
		if (operand2ErrorMessage.length() > 0)
			return false;
		operand2Defined = true;
		return true;
	}
	
	public boolean setOperand2ErrorTerm(String value) {			// The logic of this method is exactly the
		operand2Defined = false;							// same as that for operand1, above.
		if (value.length() <= 0) {
			operand2ErrorMessage = "";
			return true;
		}
		operand2ErrorTerm = new CalculatorValue(value);
		operand2ErrorMessage = operand2ErrorTerm.getErrorMessage();
		if (operand2ErrorMessage.length() > 0)
			return false;
		operand2Defined = true;
		return true;
	}

	
	/**********
	 * This public method takes an input String, checks to see if there is a non-empty input string.
	 * If so, it places the converted CalculatorValue into result, any associated error message
	 * into resuyltErrorMessage, and sets flags accordingly.
	 * 
	 * The logic of this method is similar to that for operand1 above. (There is no defined flag.)
	 * 
	 * @param value
	 * @return	True if the set did not generate an error; False if there was invalid input
	 */
	public boolean setResult(String value) {				// The logic of this method is similar to
		if (value.length() <= 0) {						// that for operand1, above.
			operand2ErrorMessage = "";
			return true;
		}
		result = new CalculatorValue(value);
		resultErrorMessage = operand2MeasuredValue.getErrorMessage();
		resultErrorMessage = operand2ErrorTerm.getErrorMessage();
		if (operand2ErrorMessage.length() > 0)
			return false;
		return true;
	}
	
	/**********
	 * This public setter sets the String explaining the current error in operand1.
	 * 
	 * @return
	 */
	public void setOperand1ErrorMessage(String m) {
		operand1ErrorMessage = m;
		return;
	}
	
	/**********
	 * This public getter fetches the String explaining the current error in operand1, it there is one,
	 * otherwise, the method returns an empty String.
	 * 
	 * @return and error message or an empty String
	 */
	public String getOperand1ErrorMessage() {
		return operand1ErrorMessage;
	}
	
	/**********
	 * This public setter sets the String explaining the current error into operand1.
	 * 
	 * @return
	 */
	public void setOperand2ErrorMessage(String m) {
		operand2ErrorMessage = m;
		return;
	}
	
	/**********
	 * This public getter fetches the String explaining the current error in operand2, it there is one,
	 * otherwise, the method returns an empty String.
	 * 
	 * @return and error message or an empty String
	 */
	public String getOperand2ErrorMessage() {
		return operand2ErrorMessage;
	}
	
	/**********
	 * This public setter sets the String explaining the current error in the result.
	 * 
	 * @return
	 */
	public void setResultErrorMessage(String m) {
		resultErrorMessage = m;
		return;
	}
	
	/**********
	 * This public getter fetches the String explaining the current error in the result, it there is one,
	 * otherwise, the method returns an empty String.
	 * 
	 * @return and error message or an empty String
	 */
	public String getResultErrorMessage() {
		return resultErrorMessage;
	}
	
	/**********
	 * This public getter fetches the defined attribute for operand1. You can't use the lack of an error 
	 * message to know that the operand is ready to be used. An empty operand has no error associated with 
	 * it, so the class checks to see if it is defined and has no error before setting this flag true.
	 * 
	 * @return true if the operand is defined and has no error, else false
	 */
	public boolean getOperand1Defined() {
		return operand1Defined;
	}
	
	/**********
	 * This public getter fetches the defined attribute for operand2. You can't use the lack of an error 
	 * message to know that the operand is ready to be used. An empty operand has no error associated with 
	 * it, so the class checks to see if it is defined and has no error before setting this flag true.
	 * 
	 * @return true if the operand is defined and has no error, else false
	 */
	public boolean getOperand2Defined() {
		return operand2Defined;
	}

	/**********************************************************************************************

	The toString() Method
	
	**********************************************************************************************/
	
	/**********
	 * This toString method invokes the toString method of the result type (CalculatorValue is this 
	 * case) to convert the value from its hidden internal representation into a String, which can be
	 * manipulated directly by the BusinessLogic and the UserInterface classes.
	 */
	public String toString() {
		return result.toString();
	}
	
	/**********
	 * This public toString method is used to display all the values of the BusinessLogic class in a
	 * textual representation for debugging purposes.
	 * 
	 * @return a String representation of the class
	 */
	public String debugToString() {
		String r = "\n******************\n*\n* Business Logic\n*\n******************\n";
		r += "operand1 = " + operand1MeasuredValue.toString() + "\n";
		r += "     operand1ErrorMessage = " + operand1ErrorMessage+ "\n";
		r += "     operand1Defined = " + operand1Defined+ "\n";
		r += "operand1 = " + operand1ErrorTerm.toString() + "\n";
		r += "     operand1ErrorMessage = " + operand1ErrorMessage+ "\n";
		r += "     operand1Defined = " + operand1Defined+ "\n";
		r += "operand2 = " + operand2MeasuredValue.toString() + "\n";
		r += "     operand2ErrorMessage = " + operand2ErrorMessage+ "\n";
		r += "     operand2Defined = " + operand2Defined+ "\n";
		r += "operand2 = " + operand2ErrorTerm.toString() + "\n";
		r += "     operand2ErrorMessage = " + operand2ErrorMessage+ "\n";
		r += "     operand2Defined = " + operand2Defined+ "\n";
		r += "result = " + result.toString() + "\n";
		r += "     resultErrorMessage = " + resultErrorMessage+ "\n";
		r += "*******************\n\n";
		return r;
	}

	/**********************************************************************************************

	Business Logic Operations (e.g. addition)
	
	**********************************************************************************************/
	
	/**********
	 * This public method computes the sum of the two operands using the CalculatorValue class method 
	 * for addition. The goal of this class is to support a wide array of different data representations 
	 * without requiring a change to this class, user interface class, or the Calculator class.
	 * 
	 * This method assumes the operands are defined and valid. It replaces the left operand with the 
	 * result of the computation and it leaves an error message, if there is one, in a String variable
	 * set aside for that purpose.
	 * 
	 * This method does not take advantage or know any detail of the representation!  All of that is
	 * hidden from this class by the ClaculatorValue class and any other classes that it may use.
	 * 
	 * @return a String representation of the result
	 */
	public String additionMeasuredValue() {
		result = new CalculatorValue(operand1MeasuredValue);
		result.add(operand2MeasuredValue);
		resultErrorMessage = result.getErrorMessage();
		return result.toString();
	}
	
	/**********
	 * The following methods are method stubs that need to be implemented.
	 * 
	 * @return
	 */
	public String subtractionMeasuredValue() {
		result = new CalculatorValue(operand1MeasuredValue);
		result.sub(operand2MeasuredValue);
		resultErrorMessage = result.getErrorMessage();
		// replace this comment with the code required to compute the result.
		
		return result.toString();
	}
	
	public String multiplicationMeasuredValue() {
		result = new CalculatorValue(operand1MeasuredValue);
		result.mpy(operand2MeasuredValue);
		resultErrorMessage = result.getErrorMessage();
		// replace this comment with the code required to compute the result.
		
		return result.toString();
	}
	
	public String divisionMeasuredValue() {
		result = new CalculatorValue(operand1MeasuredValue);
		result.div(operand2MeasuredValue);
		resultErrorMessage = result.getErrorMessage();
		return result.toString();
	}
	
	public String squareRootMeasuredValue() {
			result = new CalculatorValue(operand1MeasuredValue);
			result.sqt(operand1MeasuredValue);
			resultErrorMessage = result.getErrorMessage();
			return result.toString();
	}
	
	public String additionErrorTerm() {
		result = new CalculatorValue(operand1ErrorTerm);
		result.add(operand2ErrorTerm);
		resultErrorMessage = result.getErrorMessage();
		return result.toString();
	}
	
	public String subtractionErrorTerm() {
		result = new CalculatorValue(operand1ErrorTerm);
		result.sub(operand2ErrorTerm);
		resultErrorMessage = result.getErrorMessage();

		
		return result.toString();
	}
	
	public String multiplicationErrorTerm() {
		result = new CalculatorValue(operand1ErrorTerm);
		result.mpy(operand2ErrorTerm);
		resultErrorMessage = result.getErrorMessage();

		
		return result.toString();
	}
	
	public String divisionErrorTerm() {
		result = new CalculatorValue(operand1ErrorTerm);
		result.div(operand2ErrorTerm);
		resultErrorMessage = result.getErrorMessage();
		return result.toString();
	}
	
	public String squareRootErrorTerm() {
			result = new CalculatorValue(operand1ErrorTerm);
			result.sqt(operand1ErrorTerm);
			resultErrorMessage = result.getErrorMessage();
			return result.toString();
	}
	
}
