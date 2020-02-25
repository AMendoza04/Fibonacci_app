package com.example.fibonacci;

public class Pais {

    private String name;
    private String i_name;
    private String capC;
    private String sig;


    public Pais (String _name, String _i_name, String _capC, String _sig)
    {
        setName( _name );
        setI_name( _i_name );
        setCapC( _capC );
        setSig( _sig );
    }
    public  String toString()
    {
        String d_pais;

        d_pais = "Nombre:\n" + getName() + "\n\nNombre Internacional:\n" + getI_name() + "\n\nCapital:\n" + getCapC() + "\n\nSigla:\n" + getSig();

        return d_pais;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapC() {
        return capC;
    }

    public void setCapC(String capC) {
        this.capC = capC;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }
}
