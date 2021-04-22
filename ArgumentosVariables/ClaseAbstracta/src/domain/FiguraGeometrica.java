package domain;

public abstract class FiguraGeometrica {
    protected  String tipoFigura;

    protected FiguraGeometrica(String tipoFigura){
        this.tipoFigura = tipoFigura;

    }
    public abstract void dibujar();
    //MEtodos gett y sett

    public String getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }
    //Metodo toSring()

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FiguraGeometrica{");
        sb.append("tipoFigura='").append(tipoFigura).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
