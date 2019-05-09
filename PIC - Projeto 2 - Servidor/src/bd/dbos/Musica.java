package bd.dbos;


public class Musica {

	protected String title;
	protected String singer;
	protected String style;
	protected float price;
	protected float duration;

	public Musica(String titulo, String cantor, String estilo, float preco, float duracao) {
		this.title = titulo;
		this.singer = cantor;
		this.style = estilo;
		this.price = preco;
		this.duration = duracao;
	}

	public void setTitle(String titulo) {
		this.title = titulo;
	}

	public void setSinger(String cantor) {
		this.singer = cantor;
	}

	public void setStyle(String estilo) {
		this.style = estilo;
	}

	public void setPrice(float preco) {
		this.price = preco;
	}

	public void setDuration(float duracao) {
		this.duration = duracao;
	}

	public String getTitle() {
		return this.title;
	}

	public String getSinger() {
		return this.singer;
	}

	public String getStyle() {
		return this.style;
	}

	public float getPrice() {
		return this.price;
	}

	public float getDuration() {
		return this.duration;
	}

	public String toString() {
		return singer;
	}

	public boolean equals() {
		return false;
	}

	public int hashCode() {
		return 0;
	}
}
