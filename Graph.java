import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    static class Edge{
        int src;
        int dest;

        Edge(int src,int dest)
        {
            this.src=src;
            this.dest= dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[])
    {
        for(int i=0;i<7;i++)
        {
            graph[i]= new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));


    }
    public static void bfs(ArrayList<Edge> graph[],int V,boolean visi[],int src)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty())
        {
            int curr = queue.remove();
            if(visi[curr]==false)
            {
                System.out.print(curr+",");
                visi[curr] = true;
                for(int i=0;i<graph[curr].size();i++)
                {
                    Edge e = graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visi[])
    {
       System.out.println(curr + " ");
       visi[curr] = true;
       for(int i=0;i<graph[curr].size();i++)
       {
           Edge e = graph[curr].get(i);
           if(visi[e.dest]==false)
           dfs(graph, e.dest, visi);
       }
    }
    public static void modifieddfs(ArrayList<Edge> graph[],boolean visi[],int curr,String path,int tar)
    {
        if(curr == tar)
            System.out.println(path);
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge e = graph[curr].get(i);
            if(visi[e.dest]==false){
                visi[curr]=true;
                modifieddfs(graph,visi,e.dest,path+e.dest,tar);
                visi[curr]=false;
            }
        }
    }
    public static void main(String args[])
    {
        int V=7;
        boolean visi[] = new boolean[V];
        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        //BFS
        /*for(int i=0;i<V;i++)
        {
            if(visi[i]==false)
                bfs(graph,V,visi,i);

        }*/
       // dfs(graph,0,visi);
        modifieddfs(graph,visi,0,"0",5);
    }
}
