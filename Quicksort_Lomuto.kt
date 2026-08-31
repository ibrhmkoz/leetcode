fun quicksort(arr: IntArray): IntArray {
    if (arr.size <= 1) return arr

    fun sort(low: Int, high: Int) {
        if (low < high) {
            val pivot = arr[high]
            var i = low - 1

            for (j in low..<high) {
                if (arr[j] < pivot) {
                    i++
                    val temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                }
            }

            val p = i + 1

            val temp = arr[p]
            arr[p] = arr[high]
            arr[high] = temp

            sort(low, p - 1)
            sort(p + 1, high)
        }
    }

    sort(0, arr.size - 1)
    return arr
}
