fun quicksort(arr: IntArray): IntArray {
    if (arr.size <= 1) return arr

    fun sort(low: Int, high: Int) {
        if (low < high) {
            val pivot = arr[low]

            var i = low - 1
            var j = high + 1

            while (true) {
                do {
                    i++
                } while (arr[i] < pivot)

                do {
                    j--
                } while (arr[j] > pivot)

                if (i >= j) break

                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }

            sort(low, j)
            sort(j + 1, high)
        }
    }

    sort(0, arr.size - 1)
    return arr
}
