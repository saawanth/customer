

public class Items {
	
		String name;
		double price;
		int quantity;
		double value;
		
		public Items(String name,double price,int quantity){
			this.name= name;
			this.price= price;
			this.quantity= quantity;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getValue() {
			return value= (price*quantity);
		}

        public String toString() {
			return getName()+"\t"+ getPrice()+"\t\t"+ getQuantity()+"\t\t"+getValue();
        	
        }
    
		}
		
