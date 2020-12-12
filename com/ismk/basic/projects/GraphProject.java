package com.ismk.basic.projects;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//library to print the graph in the UI
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class GraphProject {
	
	private static final String UNDIRECTED = "Undirected";
	private static final String DIRECTED = "Directed";


	@Override
	public String toString() {
   	 Iterator<Vertex> iterator = this.neighbours.keySet().iterator();
   	 String str ="";
		 while(iterator.hasNext()) {
    		 Vertex v = iterator.next();
    		 Iterator<Vertex> iterator2 = this.neighbours.get(v).iterator();
    		 str += v+ "[";
    		while(iterator2.hasNext()) {
    			Vertex e = iterator2.next();
    			str +=e+",";
    		}
    		 str = str.substring(0, str.length()-1)+  "] ";
		 }
		
		return str+"\tV: "+V + " E: "+E;
	}

	//Graph variables
	Map<Vertex, List<Vertex>> neighbours;
	boolean visited[];
	String discoveryPathStr;
	int V;
	int E;
	int avgEdges;
	String graphTypeStr;
	//UI variables
	static JFrame frame = null;
	static Layout<Integer, String> layout;
	static BasicVisualizationServer<Integer,String> vv;
	static JLabel vertexLabel;
	static JButton button;
	static JLabel errorLabel;
	static JLabel edgesLabel;
	static JLabel discoveryPathLabel;
	static JTextField vertexNumField = new JTextField();
	static JTextField genNumField = new JTextField("1");
	static JLabel genLabel;
	static JComboBox<String> graphType;
	
	public GraphProject(int V, String grapTypeParm) {
		 
		 this.visited = new boolean[V]; 
		 this.discoveryPathStr="";
		 this.V = V;
		 this.E = 0;
		 this.graphTypeStr = grapTypeParm;
		 //Create Vertices 1 ... V
		 this.neighbours =  new HashMap<Vertex, List<Vertex>>();
		 for(int i=0; i<V; i++) {
			 this.addVertex(i+1);
		 }
	 }
	
	/**
	 * Add Vertex to the Graph
	 * @param value
	 */
	public void addVertex(Integer value) {
		
		neighbours.putIfAbsent(new Vertex(value), new ArrayList<Vertex>());
	}
	
	/**
	 * Add Edge to the Graph
	 * @param val1
	 * @param val2
	 */
	public void addEdge(Vertex v1, Vertex v2) {

	    neighbours.get(v1).add(v2);
	    if (this.graphTypeStr == UNDIRECTED)
	    	neighbours.get(v2).add(v1);
	    this.E++;
	}
	
	/**
	 * Given 2 Vertices verify if the edge already exists
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean edgeExists(Vertex v1, Vertex  v2) {
		
		if(this.neighbours.get(v1) != null) {
			Iterator<Vertex> i = this.neighbours.get(v1).iterator();
	        while (i.hasNext()) 
	        { 	
	        	if(i.next().value == v2.value )
	        		return true;
	        	
	        }
		}
        return false;
		
	}
	
	/**
	 * DFS algorithm start
	 * @param v
	 */
	public void DFS_Visit(Vertex v) 
	{ 
	        this.visited[v.value-1] = true;
	        discoveryPathStr+=(v+" "); 
	  
	        Iterator<Vertex> i = this.neighbours.get(v).iterator();
	        while (i.hasNext()) 
	        { 
	            Vertex v2 = i.next(); 
	            if (!visited[v2.value-1]) {
	            	DFS_Visit(v2); 
	            }
	        } 
	} 
  
	public void DFS(Vertex v) 
	{ 	
	    	this.visited = new boolean[V]; 
	    	this.discoveryPathStr="";
	        DFS_Visit(v); 
	 } 
	//DFS algorithm End  
	    
	private boolean allVisited() {
	    	
	    	for(boolean check: this.visited) {
	    		
	    		if (check == false)
	    			return false;
	    		
	    	}
	    	
	    	return true;
	    		
	}
	    
	/**
	 * Generate random integers 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandomIntegerBetweenRange(double min, double max){
	        double x = (int)(Math.random()*((max-min)+1))+min;
	        return (int)x;
	}
	
	
	/**
	 * Calculate Pr(n) in a connected graphs with r edges
	 * @param n
	 * @param r
	 * @param graphType
	 * @return
	 */
	static String calcPr(int n, int r, String graphType) {
		
		double x=0;
		
		if(graphType == UNDIRECTED) 
			
			x = (double)r/(n*(n-1))/2.0;
			
		else 
			x = (double)r/(n*(n-1));
		
		
		return new DecimalFormat("#.##").format(x);
		
	}
	    
	 
 	public static Stack<Integer> shuffleArray(int V) {
	    	
	    	
	    	// Create an array
	    	Integer[] array = new Integer[V];
	    	 
	    	for(int i=0; i<V; i++)
	    		array[i] = i+1;
	    		
	    	// Shuffle the elements in the array
	    	List<Integer> l = Arrays.asList(array);
	    	 
	    	Collections.shuffle(l);
	    	 
	    	Stack<Integer> st = new Stack<Integer>();
	    	
	    	st.addAll(l);

	    	return st;
	 }
	    
	
	/**
	 * Generate a Random Graph with V vertices and randomly add edges until is connected
	 * @param vertices
	 * @return
	 */
	public static GraphProject generateRandomConnectedGraph(int vertices, String graphTypeStr) {
	    	
		 	GraphProject g = new GraphProject(vertices, graphTypeStr);

		 	System.out.println("Initial state g = " + g.toString());
	        
	        int randomStart  = getRandomIntegerBetweenRange(1, g.V);
	        int randomEnd  = getRandomIntegerBetweenRange(1, g.V);

	        while (!g.allVisited() && g.V>1) {
	        	
	        	//do not repeat edges or self loops 
	        	while( randomStart == randomEnd ||
	        			(graphTypeStr == UNDIRECTED && (
	        			g.edgeExists(new Vertex(randomEnd), new Vertex(randomStart))  ||
	        			g.edgeExists(new Vertex(randomStart), new Vertex(randomEnd)) )
	        			) ||
	        		  (graphTypeStr == DIRECTED && 
	        			g.edgeExists(new Vertex(randomStart), new Vertex(randomEnd))) 
	        			) {
		        	randomStart = getRandomIntegerBetweenRange(1, g.V);
	 	        	randomEnd  = getRandomIntegerBetweenRange(1, g.V);
	        	}
	        	g.addEdge(new Vertex(randomStart), new Vertex(randomEnd));
	        	
			 	System.out.println("Current state g " + g.toString());
			 	
			 	//Call DFS algorithm with a random start
	        	g.DFS(new Vertex(getRandomIntegerBetweenRange(1, g.V)));
	        	 	        	 
	        	randomStart = getRandomIntegerBetweenRange(1, g.V);
	 	        randomEnd  = getRandomIntegerBetweenRange(1, g.V);
	        	
	        }
	        
	        System.out.println("DFS discovery path: "+ g.discoveryPathStr);
	        System.out.println("Number of Vertex: "+g.V);
	        System.out.println("Number of Edges: "+g.E);
	        
	        
	        return g;
	    	
	    }
	    
	    
	    /**
	     * Load Initial UI
	     */
	    void initializeUI() {
	    	
	        frame = new JFrame("Graph Viewer");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
	        layout = new CircleLayout<Integer, String>(g);
		    layout.setSize(new Dimension(900,800)); 
		    vv =new BasicVisualizationServer<Integer,String>(layout);
	        vv.setPreferredSize(new Dimension(900,800));
	        setComponents();
	 		      
	    	
	    }
	    /**
	     * Display components in the UI
	     */
	    static void setComponents() {
	    	vertexNumField = new JTextField(vertexNumField.getText(),5);
	    	genNumField = new JTextField(genNumField.getText(),5);
		    genLabel = new JLabel("Generations");
		    vertexLabel = new JLabel();
	 		button=new JButton("Submit");    
		 	errorLabel = new JLabel();
		 	edgesLabel =  new JLabel();
		 	discoveryPathLabel = new JLabel();
		 	int prevSelectedIndex = (graphType != null && graphType.getSelectedItem() != null )? graphType.getSelectedIndex(): 1;
		 	graphType = new JComboBox<String>(new String[] {"Directed",UNDIRECTED});
		 	graphType.setSelectedIndex(prevSelectedIndex);
	    	GroupLayout layout= new GroupLayout(frame.getContentPane());
	    	
	    	layout.setAutoCreateGaps(true); 
	        layout.setAutoCreateContainerGaps(true); 
	    	layout.setHorizontalGroup(layout.createSequentialGroup()
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	    			.addComponent(vertexLabel)
	    	        .addComponent(genLabel)
	    			.addComponent(errorLabel))
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	    	        .addComponent(vertexNumField)
	    	        .addComponent(genNumField)
	    	        .addComponent(button))
	    	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	    			.addComponent(graphType)
	    			.addComponent(edgesLabel))
	    	        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    	        .addComponent(discoveryPathLabel)
	    			.addComponent(vv)
	    			));
	    	
	        layout.setVerticalGroup(layout.createSequentialGroup() 
	        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		        	    .addComponent(vertexLabel) 
		                .addComponent(vertexNumField)
       				 	.addComponent(graphType))
	        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	        				.addComponent(genLabel)
	        				.addComponent(genNumField)
	        				.addComponent(edgesLabel))
	        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                .addComponent(button))
	        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	        				 .addComponent(errorLabel))
		    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		    				.addComponent(discoveryPathLabel)
		                .addComponent(vv))
	        		); 
	        frame.getContentPane().setLayout(layout); 

	        vertexNumField.setBounds(80, 50, 80, 30);
	        vertexLabel.setText("Vertices");
	        vertexLabel.setBounds(10, 10, 100, 100);
	 		button.setBounds(80,50,140, 40);
	        frame.pack();
	        frame.setVisible(true);
	        button.addActionListener(new ActionListener() {
	 	        
	 			@Override
	 			public void actionPerformed(ActionEvent arg0) {
	 				String numVertexStr = vertexNumField.getText();
	 				String numGenStr = genNumField.getText();

	 				if((numVertexStr != null  && !numVertexStr.isBlank())
	 						&& (numGenStr != null && !numGenStr.isBlank())){
	 					errorLabel.setText("");
	 					try {
	 						int numVertexInt = Integer.parseInt(numVertexStr);
	 						int numGenInt = Integer.parseInt(numGenStr);
	 						String graphTypeStr = (String)graphType.getSelectedItem();
	 						GraphProject.generateSetOfGraphs(numVertexInt,numGenInt, graphTypeStr).display();
	 					
	 					}catch(Exception e) {
	 						
	 						errorLabel.setText("Invalid number. ");
	 						e.printStackTrace();
	 						
	 					}
	        	 
	 				}
	 				else {
 						errorLabel.setText("Invalid number. ");

	 				}
	 			}          
	 	      });
	    	
	    }
	    
	    /**
	     * Generate A Set of random Graphs and calculate AVG(E)
	     * @param vertex
	     * @param numGen
	     * @param graphType
	     * @return
	     */
	    static GraphProject generateSetOfGraphs(int vertex, int numGen, String graphType) {
	    	
	    	GraphProject[] arrayG = new GraphProject[numGen];
	    	int sumEdges = 0;
	    	int lowestCount= vertex*(vertex-1), indexLowest=0;
	    	for(int i=0; i<numGen; i++) {
	    		arrayG[i] =  GraphProject.generateRandomConnectedGraph(vertex, graphType);
	    		sumEdges += arrayG[i].E; 
	    		if(arrayG[i].E <= lowestCount) {
	    			lowestCount = arrayG[i].E;
	    			indexLowest= i;
	    		}
	    		
	    	}
	    	
	    	arrayG[indexLowest].avgEdges = sumEdges/(int)numGen;
	    	return arrayG[indexLowest];
	    	
	    }
	    
	    
	    /**
	     * Displays a graph in the UI
	     * @param p
	     */
	   public void display() {
	    	
		   	 //Create graph display layout and components
	    	 Graph<Integer, String> g = new SparseMultigraph<Integer, String>();
	    	 Iterator<Vertex> iterator = this.neighbours.keySet().iterator();
	    	 while(iterator.hasNext()) {
	    		 Vertex v = iterator.next();
	    		 Iterator<Vertex> iterator2 = this.neighbours.get(v).iterator();
	    		while(iterator2.hasNext()) {
	    			Vertex e = iterator2.next();
	    		 
	    		 		if (this.graphTypeStr.trim() == DIRECTED) {
	    		 			g.addEdge(
	    		 					(g.findEdge(v.value,e.value) == null)?"Edge "+v.value+"-"+e.value :"Edge "+v.value*2+"-"+e.value
	    		 					, v.value, e.value, EdgeType.DIRECTED);
	    		 		}else {
	    		 			if(g.findEdge(v.value,e.value) == null 
	    			    		 	|| g.findEdge(e.value,v.value) == null) 
	    		 				g.addEdge("Edge "+v.value+"-"+e.value, v.value, e.value);
	    		 		}
	    		 		
	    		 	
	    		}	
	    	}
	    	 
	    	 layout = new CircleLayout<Integer, String>(g);
		     layout.setSize(new Dimension(900,800)); 
		     vv =new BasicVisualizationServer<Integer,String>(layout);
		     vv.setPreferredSize(new Dimension(900,800));

		 	 float dash[] = {10.0f};
		         final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE,
		                 BasicStroke.CAP_SQUARE, 10.0f, dash, 0.0f);
		            Transformer<String, Stroke> edgeStrokeTransformer =
		                  new Transformer<String, Stroke>() {
		                public Stroke transform(String s) {
		                    return edgeStroke;
		                }
		            };
	            vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
	            vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
	            vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<String>());
	            vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
	            frame.getContentPane().removeAll();
			    setComponents();
			    discoveryPathLabel.setText("G["+g.getVertexCount()+","+g.getEdgeCount()+"]"+ 
			    		" - DFS Path: "+(this.discoveryPathStr.length() >25? this.discoveryPathStr.substring(0,25)+"...":this.discoveryPathStr));
					edgesLabel.setText("Avg. Edges: "+this.avgEdges
									+", P(n): "+calcPr(this.V,this.E,this.graphTypeStr)
									);
	            frame.pack();
		     
	    }
	   
	
	
	public static void main(String[] args) {
		
		 	new GraphProject(0,UNDIRECTED).initializeUI();
		 	
	        
	       
	}

}
