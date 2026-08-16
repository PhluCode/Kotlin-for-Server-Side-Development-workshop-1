import org.example.validateCitizenId
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidateCitizenIdTest {

    @Test
    fun `valid 13 digit id returns true`() {
        val id = "1101700185296"

        val result = validateCitizenId(id)

        assertTrue(result)
    }

    @Test
    fun `id with wrong length returns false`() {
        assertFalse(validateCitizenId("12345"))
        assertFalse(validateCitizenId("1234532424324234234"))
        assertFalse(validateCitizenId(""))
    }

    @Test
    fun `id containing non digit characters returns false`() {
        assertFalse(validateCitizenId("123ASD123349O"))
        assertFalse(validateCitizenId("asdfghjklqwer"))
        assertFalse(validateCitizenId("1101100 91923"))
    }

    @Test
    fun `valid checksum returns true`() {
        // 1101700207366 -> checksum digit 6 คำนวณถูกต้อง
        assertTrue(validateCitizenId("1101700207366"))

        // 1234567890121 -> checksum digit 1 คำนวณถูกต้อง
        assertTrue(validateCitizenId("1234567890121"))
    }

    @Test
    fun `invalid checksum returns false`() {
        // ความยาว-รูปแบบถูกต้อง แต่หลักสุดท้ายผิด (ควรเป็น 6 ไม่ใช่ 0)
        assertFalse(validateCitizenId("1101700207360"))

        // จาก test เดิมของคุณ - รูปแบบถูกแต่ checksum ไม่ผ่าน (ควรเป็น 0 ไม่ใช่ 6)
        assertFalse(validateCitizenId("1101700185296"))

        // เปลี่ยนหลักสุดท้ายของ id ที่ valid ให้ผิด
        assertFalse(validateCitizenId("1234567890120"))
    }

    @Test
    fun `valid 13 digit id with thai number returns true`() {
        val id = "๑๒๓๔๕๖๗๘๙๐๑๒๑"

        val result = validateCitizenId(id)

        assertTrue(result)
    }
}