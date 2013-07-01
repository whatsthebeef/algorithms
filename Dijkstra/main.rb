class Vertex
   attr_accessor :edges, :td, :name, :previous, :visited
   def initialize(name)
      @name = name
      @td = Float::INFINITY
      @edges = []
   end
end

class Edge
   attr_accessor :weight, :dest
   def initialize(weight, dest)
      @weight = weight
      @dest = dest
   end
end

uv = [Vertex.new(0), Vertex.new(1), Vertex.new(2), Vertex.new(3), Vertex.new(4)]
t = uv[4]
s = uv[0]

uv[0].edges << Edge.new(2, uv[1])
uv[0].edges << Edge.new(3, uv[2])
uv[1].edges << Edge.new(3, uv[3])
uv[1].edges << Edge.new(2, uv[0])
uv[2].edges << Edge.new(3, uv[4])
uv[2].edges << Edge.new(3, uv[0])
uv[3].edges << Edge.new(3, uv[1])
uv[3].edges << Edge.new(5, uv[4])
uv[4].edges << Edge.new(5, uv[3])
uv[4].edges << Edge.new(3, uv[2])

s.td = 0

def dijkstra(source, dest, uv)
   vv = []
   current_v = source
   while !uv.empty? and !current_v.eql?(dest)
      vv << current_v = uv.delete(current_v)
      current_v.visited = true
      current_v.edges.each do |e|
         unless(e.dest.visited)
            puts "Potential tentative distance : #{e.weight + current_v.td} and current tentative distance #{e.dest.td.to_s}"
            if((e.weight + current_v.td) < e.dest.td)
               e.dest.td = e.weight + current_v.td 
               puts "Sets tentative distance of #{e.dest.name} to #{e.dest.td}"
               e.dest.previous = current_v
            end
         end
      end
      current_v = nil
      uv.each {|v| if(current_v.nil? or v.td < current_v.td) then current_v = v end}
      puts "Remaining vector with lowest tentative distance : #{current_v.name}"
   end
   return vv
end

vv = dijkstra(s, t, uv)

sp = [t]
while !sp.last.previous.nil?
   sp << sp.last.previous
end
sp.reverse!
sp.each {|v| puts v.name}

