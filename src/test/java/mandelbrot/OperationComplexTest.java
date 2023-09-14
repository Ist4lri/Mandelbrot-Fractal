package mandelbrot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperationComplexTest {
    private Complex onePlusI;
    private Complex minusI;
    private Complex oneMinusI;
    private Complex twoI;
    private Complex two;
    private Complex one;
    private Complex i;
    private Complex zero;
    private Complex twoPlusTwoI;

    @BeforeEach
    void initializeTestValues() {
        onePlusI = new Complex(1, 1);
        minusI = new Complex(0, -1);
        oneMinusI = new Complex(1, -1);
        twoI = new Complex(0, 2);
        two = new Complex(2, 0);
        one = new Complex(1, 0);
        i = new Complex(0, 1);
        zero = new Complex(0, 0);
        twoPlusTwoI = new Complex(2, 2);
    }

    @Test
    void testEquals() {
        assertThat(Complex.real(1)).isEqualTo(one);
        assertThat(Complex.real(2)).isEqualTo(two);
        assertThat(Complex.real(0)).isEqualTo(zero);
    }

    @Test
    void testAdding() {
        assertThat(onePlusI.add(onePlusI)).isEqualTo(new Complex(2, 2));
        assertThat(oneMinusI.add(onePlusI)).isNotEqualTo(oneMinusI);
        assertThat(oneMinusI.add(onePlusI)).isNotEqualTo(onePlusI);
        assertThat(oneMinusI.add(onePlusI)).isEqualTo(Complex.real(2));
    }

    @Test
    void testSubstract() {
        assertThat(onePlusI.subtract(onePlusI)).isEqualTo(zero);
        assertThat(oneMinusI.subtract(onePlusI)).isNotEqualTo(oneMinusI);
        assertThat(oneMinusI.subtract(onePlusI)).isNotEqualTo(onePlusI);
        assertThat(oneMinusI.subtract(oneMinusI)).isEqualTo(new Complex(0, 0));
    }

    @Test
    void testMultiply() {
        assertThat(onePlusI.multiply(two)).isEqualTo(new Complex(2, 0));
        assertThat(oneMinusI.multiply(onePlusI)).isNotEqualTo(onePlusI);
        assertThat(oneMinusI.multiply(oneMinusI)).isNotEqualTo(oneMinusI);
        assertThat(two.multiply(twoI)).isEqualTo(new Complex(0, 0));
    }

    @Test
    void testSquareModulus() {
        assertThat(two.squaredModulus()).isEqualTo(4.0);
        assertThat(oneMinusI.squaredModulus()).isEqualTo(2.0);
        assertThat(twoPlusTwoI.squaredModulus()).isEqualTo(8.0);
    }

    @Test
    void testModulus() {
        assertThat(two.modulus()).isEqualTo(2.0);
        assertThat(minusI.modulus()).isEqualTo(1.0);
        assertThat(twoPlusTwoI.modulus()).isEqualTo(Math.sqrt(8));
        assertThat(i.modulus()).isEqualTo(1);
    }

    @Test
    void testPow() {
        assertThat(two.pow(2)).isEqualTo(new Complex(4, 0));
        assertThat(twoPlusTwoI.pow(4)).isEqualTo(new Complex(16, 0));
        assertThat(one.pow(7)).isEqualTo(new Complex(1, 0));
    }

    @Test
    void testScalar() {
        assertThat(two.scale(2.0)).isEqualTo(new Complex(4, 0));
        assertThat(twoPlusTwoI.scale(4.0)).isEqualTo(new Complex(8, 8));
        assertThat(one.scale(7.0)).isEqualTo(new Complex(7, 0));
    }

}