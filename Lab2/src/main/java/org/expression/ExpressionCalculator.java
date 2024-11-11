package org.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionCalculator {

    public Map<String, Double> variables = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        calculator.run();
    }

    public void run() {
        System.out.println("Введите выражение для вычисления (или 'exit' для выхода):");
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double result = evaluateExpression(expression);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public double evaluateExpression(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", ""); // Убираем пробелы
        return evaluate(parseExpression(expression));
    }

    private double evaluate(Node node) throws Exception {
        if (node instanceof ValueNode) {
            return ((ValueNode) node).getValue();
        } else if (node instanceof OperationNode) {
            OperationNode operation = (OperationNode) node;
            double left = evaluate(operation.getLeft());
            double right = evaluate(operation.getRight());
            switch (operation.getOperator()) {
                case '+': return left + right;
                case '-': return left - right;
                case '*': return left * right;
                case '/':
                    if (right == 0) throw new ArithmeticException("Деление на ноль");
                    return left / right;
                default: throw new Exception("Неизвестный оператор: " + operation.getOperator());
            }
        }
        throw new Exception("Неизвестный узел: " + node);
    }

    private Node parseExpression(String expression) throws Exception {
        // Простой парсер для выражений
        Stack<Node> nodes = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i++));
                }
                i--; // Вернуться к последнему символу
                nodes.push(new ValueNode(Double.parseDouble(number.toString())));
            } else if (Character.isLetter(c)) {
                StringBuilder variable = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    variable.append(expression.charAt(i++));
                }
                i--; // Вернуться к последнему символу
                String varName = variable.toString();
                if (!variables.containsKey(varName)) {
                    System.out.print("Введите значение для переменной '" + varName + "': ");
                    double value = scanner.nextDouble();
                    scanner.nextLine(); // Очистка буфера
                    variables.put(varName, value);
                }
                nodes.push(new ValueNode(variables.get(varName)));
            } else if ("+-*/".indexOf(c) != -1) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    nodes.push(new OperationNode(nodes.pop(), nodes.pop(), operators.pop()));
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    nodes.push(new OperationNode(nodes.pop(), nodes.pop(), operators.pop()));
                }
                operators.pop(); // Удаляем '('
            } else {
                throw new Exception("Некорректный символ: " + c);
            }
        }

        while (!operators.isEmpty()) {
            nodes.push(new OperationNode(nodes.pop(), nodes.pop(), operators.pop()));
        }

        return nodes.pop();
    }

    private int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    interface Node {}

    static class ValueNode implements Node {
        private final double value;

        ValueNode(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    static class OperationNode implements Node {
        private final Node right;
        private final Node left;
        private final char operator;

        OperationNode(Node right, Node left, char operator) {
            this.right = right;
            this.left = left;
            this.operator = operator;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public char getOperator() {
            return operator;
        }
    }
}
