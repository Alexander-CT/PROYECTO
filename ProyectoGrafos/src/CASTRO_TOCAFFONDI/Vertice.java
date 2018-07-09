package CASTRO_TOCAFFONDI;
/**
 *
 * @author CASTRO TOCAFFONDI
 */
class Vertice implements Comparable<Vertice> {
    private String id;
    private Integer distancia;
    
    public Vertice(String id, Integer distancia) {
	super();
	this.id = id;
	this.distancia = distancia;
    }

    public String getId() {
	return id;
    }

    public Integer getDistancia() {
	return distancia;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setDistancia(Integer distancia) {
	this.distancia = distancia;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }
	
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
            return true;
	if (obj == null)
            return false;
	if (getClass() != obj.getClass())
            return false;
        Vertice other = (Vertice) obj;
	if (distancia == null) {
            if (other.distancia != null)
		return false;
	} else if (!distancia.equals(other.distancia))
            return false;
	if (id == null) {
            if (other.id != null)
		return false;
        } else if (!id.equals(other.id))
            return false;
            return true;
    }

    @Override
    public String toString() {
	return "Vertex [id=" + id + ", distance=" + distancia + "]";
    }

    @Override
    public int compareTo(Vertice o) {
	if (this.distancia < o.distancia){
            return -1;
        }else{
            if (this.distancia > o.distancia){
                return 1;
            }else{
                return this.getId().compareTo(o.getId());
            }
        }
    }
}
