arr = [1,3,6,8,3,5,0,1,4,7,4,9];

def quick_sort(arr)
   if(arr.size <= 1) then return arr end
   puts "Array : #{arr.inspect}"
   puts "Array size : #{arr.size}"
   puts "Pivot point: #{arr.size/2}"
   pivot = arr.delete_at(arr.size/2)
   puts "Pivot : #{pivot}"
   less = []
   greater = []
   arr.each do |e|
      if(e <= pivot) 
         less << e
      else
         greater << e
      end
   end
   return quick_sort(less).concat([pivot]).concat(quick_sort(greater))
end

puts quick_sort(arr).inspect
