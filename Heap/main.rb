class Heap
   attr_accessor :arr, :hs

   def initialize
      @hs = arr.size
   end

   def left_i(node_i)
      node_i*2
   end

   def right_i(node_i)
      (node_i*2)+1
   end

   def parent_i(node_i)
      (node_i/2)
   end

   def swap(i, j)
      old_i = arr[i]
      arr[i] = arr[j]
      arr[j] = old_i
   end

   def max_heapify(i)
      largest = -1
      l = left_i(i)
      r = right_i(i)
      if l_i <= hs and arr[l] > arr[i] then largest = l
      else largest = i end

      if r_i <= hs and arr[r] > arr[largest] then largest = a end

      if largest != i
         swap(i, largest)
         max_heapify(largest)
      end
   end

   def build_max_heap
      (hs.downto(0)/2) do |i|
         max_heapify(i)
      end
   end

   def heap_sort
      build_max_heap
      arr.size.downto(1) do |i|
         swap(0, i)
         hs -= 1
         max_heapify(i)
      end
   end
end


