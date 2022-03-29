package com.circles24.threadstates;

import java.util.Arrays;

public enum Operation {
    ADDITION {
        public long compute(long num1, long num2) {
            return num1+num2;
        }

        public boolean isValidOption(String option) {
            return ADDITION_OPTION.equals(option);
        }
    },
    SUBTRACTION {
        public long compute(long num1, long num2) {
            return num1-num2;
        }

        public boolean isValidOption(String option) {
            return SUBTRACTION_OPTION.equals(option);
        }
    },
    MULTIPLICATION {
        public long compute(long num1, long num2) {
            return num1*num2;
        }

        public boolean isValidOption(String option) {
            return MULTIPLICATION_OPTION.equals(option);
        }
    },
    DIVISION {
        public long compute(long num1, long num2) {
            return num1/num2;
        }

        public boolean isValidOption(String option) {
            return DIVISION_OPTION.equals(option);
        }
    };

    private static final String ADDITION_OPTION = "1";

    private static final String SUBTRACTION_OPTION = "2";

    private static final String MULTIPLICATION_OPTION = "3";

    private static final String DIVISION_OPTION = "4";

    protected abstract boolean isValidOption(String option);

    protected abstract long compute(long num1, long num2);

    public static long compute(String option, long num1, long num2) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.isValidOption(option))
                .findFirst().orElseThrow(Error.INVALID_OPTION::build)
                .compute(num1, num2);
    }
}
