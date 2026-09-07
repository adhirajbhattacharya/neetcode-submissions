class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!Operation.signs().contains(token)) stack.push(Integer.parseInt(token));
            else {
                int second = stack.pop();
                int first = stack.pop();
                int result = Operation.getOperation(token).apply(first, second);
                stack.push(result);
            }
        }
        return stack.pop();
    }
}

enum Operation {
    ADD("+") {
        int apply(int a, int b) {
            return a + b;
        }
    },
    SUBSTRACT("-") {
        int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        int apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        int apply(int a, int b) {
            return a / b;
        }
    };

    String sign;
    abstract int apply(int a, int b);

    Operation(String sign) {
        this.sign = sign;
    }

    static Map<String, Operation> operationsMap;

    static {
        operationsMap = new HashMap<>();
        Arrays.stream(Operation.values())
                .forEach(op -> {
                    operationsMap.put(op.sign, op);
                });
    }

    static Operation getOperation(String sign) {
        return operationsMap.get(sign);
    }

    static Set<String> signs() {
        return operationsMap.keySet();
    }
}