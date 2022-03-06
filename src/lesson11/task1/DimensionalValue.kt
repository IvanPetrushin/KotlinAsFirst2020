<<<<<<< .merge_file_a12260
@file:Suppress("UNUSED_PARAMETER")
=======
@file:Suppress("UNUSED_P()ARAMETER")

>>>>>>> .merge_file_a11104
package lesson11.task1

import java.lang.IllegalArgumentException

/**
 * Класс "Величина с размерностью".
 *
 * Предназначен для представления величин вроде "6 метров" или "3 килограмма"
 * Общая сложность задания - средняя, общая ценность в баллах -- 18
 * Величины с размерностью можно складывать, вычитать, делить, менять им знак.
 * Их также можно умножать и делить на число.
 *
 * В конструктор передаётся вещественное значение и строковая размерность.
 * Строковая размерность может:
 * - либо строго соответствовать одной из abbreviation класса Dimension (m, g)
 * - либо соответствовать одной из приставок, к которой приписана сама размерность (Km, Kg, mm, mg)
 * - во всех остальных случаях следует бросить IllegalArgumentException
 */
class DimensionalValue(value: Double, dimension: String) :
    Comparable<DimensionalValue> {
    /**
     * Величина с БАЗОВОЙ размерностью (например для 1.0Kg следует вернуть результат в граммах -- 1000.0)
     */
    val value: Double

    /**
     * БАЗОВАЯ размерность (опять-таки для 1.0Kg следует вернуть GRAM)
     */
    val dimension: Dimension

    init {
<<<<<<< .merge_file_a12260

        this.dimension = Dimension.dimensionMap[dimension.last().toString()]
            ?: throw IllegalArgumentException("$dimension is unknown")
        if (dimension.length == 1) this.value = value
        else {
            if (!DimensionPrefix.dimensionMap.containsKey(dimension.first().toString()))
                throw IllegalArgumentException("$dimension is unknown")
            else this.value = value * DimensionPrefix.dimensionMap[dimension.first().toString()]!!
        }
    }

=======
        this.dimension = Dimension.map[dimension.last().toString()]
            ?: throw IllegalArgumentException("Incorrect dimension $dimension")

        val prefix = dimension.replaceFirst(this.dimension.abbreviation, "")
        this.value = value * (DimensionPrefix.map[prefix]
            ?: throw IllegalArgumentException("Incorrect dimension prefix $prefix"))
    }
>>>>>>> .merge_file_a11104

    /**
     * Конструктор из строки. Формат строки: значение пробел размерность (1 Kg, 3 mm, 100 g и так далее).
     */
<<<<<<< .merge_file_a12260
    constructor(s: String) : this(
        if (!s.matches(Regex("""((-\d+|\d+) \w+)"""))) throw IllegalArgumentException("Incorrect data")
        else s.split(" ")[0].toDouble(), s.split(" ")[1])
=======
//    constructor(s: String) : this(s.split(" ")[0].toDouble(), s.split(" ")[1]) {
//        if (s.matches(Regex("""\d+ \w+"""))) {
//            val _s = s
//        } else throw IllegalArgumentException("Incorrect input string")
//    }

    constructor(s: String) : this(
        if (s.matches(Regex("""-?\d+ \w+""")))
            s.split(" ")[0].toDouble()
        else throw IllegalArgumentException("Incorrect input string"),
        s.split(" ")[1]
    )
>>>>>>> .merge_file_a11104

    /**
     * Сложение с другой величиной. Если базовая размерность разная, бросить IllegalArgumentException
     * (нельзя складывать метры и килограммы)
     */
<<<<<<< .merge_file_a12260
    operator fun plus(other: DimensionalValue): DimensionalValue =
        if (other.dimension == this.dimension) DimensionalValue(
            this.value + other.value,
            this.dimension.abbreviation
        )
        else throw IllegalArgumentException("${other.dimension} can't be added to ${this.dimension}")

    /**
     * Смена знака величины
     */
    operator fun unaryMinus(): DimensionalValue =
        DimensionalValue(-this.value, this.dimension.abbreviation)
=======
    operator fun plus(other: DimensionalValue): DimensionalValue {
        if (dimension != other.dimension) throw IllegalArgumentException()
        return DimensionalValue(value + other.value, dimension.abbreviation)
    }

    /**
     * Смена знака величины
     */
    operator fun unaryMinus(): DimensionalValue = DimensionalValue(-value, dimension.abbreviation)
>>>>>>> .merge_file_a11104

    /**
     * Вычитание другой величины. Если базовая размерность разная, бросить IllegalArgumentException
     */
<<<<<<< .merge_file_a12260
    operator fun minus(other: DimensionalValue): DimensionalValue =
        if (other.dimension == this.dimension) DimensionalValue(
            this.value - other.value, this.dimension.abbreviation
        ) else throw IllegalArgumentException("${this.dimension} can't be subtracted from ${other.dimension}")

    /**
     * Умножение на число
     */
    operator fun times(other: Double): DimensionalValue =
        DimensionalValue(this.value * other, this.dimension.abbreviation)

    /**
     * Деление на число
     */
    operator fun div(other: Double): DimensionalValue =
        DimensionalValue(this.value / other, this.dimension.abbreviation)
=======
    operator fun minus(other: DimensionalValue): DimensionalValue {
        if (dimension != other.dimension) throw IllegalArgumentException()
        return DimensionalValue(value - other.value, dimension.abbreviation)
    }

    /**
     * Умножение на число
     */
    operator fun times(other: Double): DimensionalValue = DimensionalValue(value * other, dimension.abbreviation)

    /**
     * Деление на число
     */
    operator fun div(other: Double): DimensionalValue = DimensionalValue(value / other, dimension.abbreviation)
>>>>>>> .merge_file_a11104

    /**
     * Деление на другую величину. Если базовая размерность разная, бросить IllegalArgumentException
     */
<<<<<<< .merge_file_a12260
    operator fun div(other: DimensionalValue): Double =
        if (this.dimension == other.dimension) this.value / other.value
        else throw  IllegalArgumentException("${this.dimension} can't be divided by ${other.dimension}")
=======
    operator fun div(other: DimensionalValue): Double {
        if (dimension != other.dimension) throw IllegalArgumentException()
        return value / other.value
    }
>>>>>>> .merge_file_a11104

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean =
<<<<<<< .merge_file_a12260
        other is DimensionalValue && this.dimension == other.dimension && this.dimension == other.dimension

=======
        (other is DimensionalValue) && (dimension == other.dimension) && (value == other.value)
>>>>>>> .merge_file_a11104

    /**
     * Сравнение на больше/меньше. Если базовая размерность разная, бросить IllegalArgumentException
     */
<<<<<<< .merge_file_a12260
    override fun compareTo(other: DimensionalValue): Int =
        if (this.dimension == other.dimension) {
            if (this.value > other.value) 1
            else if (this.value < other.value) -1
            else 0
        } else throw IllegalArgumentException("${this.dimension} can't be compared with ${other.dimension}")
=======
    override fun compareTo(other: DimensionalValue): Int {
        if (dimension != other.dimension) throw IllegalArgumentException()
        return value.compareTo(other.value)
    }
>>>>>>> .merge_file_a11104

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + dimension.hashCode()
        return result
    }
<<<<<<< .merge_file_a12260

=======
>>>>>>> .merge_file_a11104
}

/**
 * Размерность. В этот класс можно добавлять новые варианты (секунды, амперы, прочие), но нельзя убирать
 */
enum class Dimension(val abbreviation: String) {
    METER("m"),
    GRAM("g");

<<<<<<< .merge_file_a12260
    companion object { val dimensionMap = values().associateBy { it.abbreviation } }

=======
    companion object {
        val map = values().associateBy({ it.abbreviation }) { it }
    }
>>>>>>> .merge_file_a11104
}

/**
 * Приставка размерности. Опять-таки можно добавить новые варианты (деци-, санти-, мега-, ...), но нельзя убирать
 */
enum class DimensionPrefix(val abbreviation: String, val multiplier: Double) {
    ONE("", 1.0),
    KILO("K", 1000.0),
    MILLI("m", 0.001);

<<<<<<< .merge_file_a12260
    companion object { val dimensionMap = values().associateBy({ it.abbreviation }) { it.multiplier } }
}
=======
    companion object {
        val map = values().associateBy({ it.abbreviation }) { it.multiplier }
    }
}
>>>>>>> .merge_file_a11104
