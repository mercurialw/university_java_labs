import org.expression.ExpressionCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressionCalculatorTest {

    private ExpressionCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new ExpressionCalculator();
    }

    @Test
    public void testSimpleAddition() throws Exception {
        double result = calculator.evaluateExpression("2 + 3");
        assertEquals(5, result, 0.0001);
    }

    @Test
    public void testSimpleSubtraction() throws Exception {
        double result = calculator.evaluateExpression("5 - 3");
        assertEquals(2, result, 0.0001);
    }

    @Test
    public void testSimpleMultiplication() throws Exception {
        double result = calculator.evaluateExpression("3 * 4");
        assertEquals(12, result, 0.0001);
    }

    @Test
    public void testSimpleDivision() throws Exception {
        double result = calculator.evaluateExpression("8 / 2");
        assertEquals(4, result, 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.evaluateExpression("1 / 0");
        });
        assertEquals("Деление на ноль", exception.getMessage());
    }

    @Test
    public void testParentheses() throws Exception {
        double result = calculator.evaluateExpression("(2 + 3) * 4");
        assertEquals(20, result, 0.0001);
    }

    @Test
    public void testVariableUsage() throws Exception {
        // Симулируем ввод переменной
        calculator.variables.put("x", 5.0);
        double result = calculator.evaluateExpression("x + 3");
        assertEquals(8, result, 0.0001);
    }

    @Test
    public void testVariableInput() throws Exception {
        // Настроим вывод с помощью фиктивного ввода
        // В данном случае через создание тестового ввода можно будет симулировать ввод
        // в методах вашего калькулятора
        calculator.variables.put("a", 10.0);
        double result = calculator.evaluateExpression("a * 2 + 3");
        assertEquals(23, result, 0.0001);
    }

    @Test
    public void testInvalidCharacter() {
        Exception exception = assertThrows(Exception.class, () -> {
            calculator.evaluateExpression("3 + # 4");
        });
        assertTrue(exception.getMessage().contains("Некорректный символ"));
    }

}
