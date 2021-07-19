package esame_2_html_lettere1;


class Y extends X {
   
	public Y() {
	
	}
	@Override
    public void me(){
        System.out.println("Y");
        stampa();
    }
    
    public void greet(Y y) {
        System.out.println("greet(Y)");
        stampa();
    } 
    
    public void stampa() {
    	System.out.println("Sto qua Y");
    }
}
