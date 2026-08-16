import org.example.Product
import org.example.calculateTotalElecPriceOver500
import kotlin.test.assertEquals
import kotlin.test.Test

class Workshop2Test {


    @Test
    fun `test total electronics price over 500`() {
        // Arrange
        val products = listOf(
            Product("Laptop", 35000.0, "Electronics"),
            Product("Smartphone", 25000.0, "Electronics"),
            Product("T-shirt", 450.0, "Apparel"),
            Product("Monitor", 7500.0, "Electronics"),
            Product("Keyboard", 499.0, "Electronics"),
            Product("Jeans", 1200.0, "Apparel"),
            Product("Headphones", 1800.0, "Electronics")
        )

        // Act
        val result = calculateTotalElecPriceOver500(products)

        // Assert
        assertEquals(69300.0, result)
    }

    @Test
    fun `test no electronics price over 500`() {
        // Arrange
        val products = listOf(
            Product("Keyboard", 499.0, "Electronics"),
            Product("T-shirt", 450.0, "Apparel")
        )

        // Act
        val result = calculateTotalElecPriceOver500(products)

        // Assert
        assertEquals(0.0, result)
    }

    @Test
    fun `test only electronics products are included`() {
        // Arrange
        val products = listOf(
            Product("Laptop", 35000.0, "Electronics"),
            Product("Jeans", 1200.0, "Apparel")
        )

        // Act
        val result = calculateTotalElecPriceOver500(products)

        // Assert
        assertEquals(35000.0, result)
    }
}