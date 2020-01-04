package _04_stack;

public class CalculatorDemo {

    public static void main(String[] args) {
        //根据前面老师思路，完成表达式的运算
//        String expression = "111-110"; // 15//如何处理多位数的问题？
//        String expression = "7*2*2-5+11-5+3-4+2*500*10"; // 15//如何处理多位数的问题？
//        String expression = "111*56-32*12+30*12-33-12+23+2*8*6"; // 15//如何处理多位数的问题？
        String expression = "111*56-32*12+30*12"; //
        //创建两个栈，数栈，一个符号栈
        MyStack numStack = new MyStack(10);
        MyStack operStack = new MyStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String numString = "";

        while (true) {
            char ch = expression.charAt(index);

            //判断当前字符是不是运算符号
            if (MyStack.isOper(ch)) {
                //如果运算符号栈为空，则直接入栈
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    //如果运算符栈不为空, 比较当前运算符和栈顶运算符的优先级

                    //如果栈顶运算符的优先级低于当前运算符的优先级, 直接入栈
                    if (MyStack.priority(operStack.peek()) < MyStack.priority(ch)) {
                        operStack.push(ch);
                    } else {

                        //如果栈顶运算符的优先级大于或等于当前运算符的优先级, 则计算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();

                        res = MyStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }
                }
            } else {
                //当前字符是数字
                numString += ch;

                int temp = index + 1;
                while (temp < expression.length() && !MyStack.isOper(expression.charAt(temp))) {
                    numString += expression.charAt(temp);
                    temp++;
                }

                numStack.push(Integer.parseInt(numString));
                numString = "";
                index = temp - 1;
            }

            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();

            res = MyStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        int value = numStack.pop();
        System.out.println(value);
    }
}

class MyStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;// top表示栈顶，初始化为-1

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }

        top++;
        stack[top] = value;
    }

    //出栈-pop, 将栈顶的数据返回
    public int pop() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }

        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~");
        }

        return stack[top];
    }

    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }

    public static boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public static int cal(int num1, int num2, int oper) {
        int res = 0; // res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;// 注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
