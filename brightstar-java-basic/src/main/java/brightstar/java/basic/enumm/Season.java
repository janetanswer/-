package brightstar.java.basic.enumm;


/*https://www.cnblogs.com/alter888/p/9163612.html*/
public enum Season {
	
	SPRING("WARM"){
		@Override
        public int getDays() {
            return 100;
        }
	},
    SUMMER("HOT"){
		@Override
        public int getDays() {
            return 100;
        }
	},
    AUTUMN("COOL"){
		@Override
        public int getDays() {
            return 100;
        }
	},
    WINTER("CODE"){
		@Override
        public int getDays() {
            return 100;
        }
	};
	
	private String feel;
	
	private Season(String feel) {
		this.feel = feel;
	}

	public String getFeel() {
		return feel;
	}
	
	public abstract int getDays();
	

}
