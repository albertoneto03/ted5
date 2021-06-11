package projetoCachorro;

import java.util.Random;

public class Cachorro {
    private String nome;
    private String raca;
    private char sexo;
    private int idade;
    private int energia;
    private int filhotes;

    public Cachorro(String nome, String raca, char sexo, int idade) {
        this.nome = nome;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.energia = 100;
        this.filhotes = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getFilhotes() {
        return filhotes;
    }

    public void setFilhotes(int filhotes) {
        this.filhotes = filhotes;
    }

    public void obterDados() {
        System.out.println("Cachorro: " + "nome=" + nome + ", raca=" + raca + ", sexo=" + sexo + ", idade=" + idade + ", energia=" + energia + ", filhotes=" + filhotes);
    }
    
    public int comer(char comida){
        if(this.energia <= 50){
            switch(comida){
                case 'R':{
                    setEnergia(getEnergia() + 50);
                    break;
                }
                case 'C':{
                    setEnergia(getEnergia() + 40);
                    break;
                }
                case 'L':{
                   setEnergia(getEnergia() + 30);
                   break;
                }
            }
        }else{
            System.out.println("Energia insuficiente, valor minimo : 50");
            return -1;
        }
        System.out.println(getEnergia());
        return getEnergia();
    }
    
    public int brincar(char brincadeira){
        if(this.energia >= 40){
            switch(brincadeira){
                case 'B':{
                    setEnergia(getEnergia() - 30);
                    break;
                }
                case 'S':{
                    setEnergia(getEnergia() - 40);
                    break;
                }
                case 'G':{
                    setEnergia(getEnergia() - 50);
                    break;
                }
            }
        }else{
            System.out.println("Energia insuficiente, valor minimo: 40");
            return -1;
        }
        System.out.println(getEnergia());
        return getEnergia();
    }
    
    public boolean podeCruzar(Cachorro parceiro){
        if((this.idade > 1 && idade < 9) && 
           (this.raca.equalsIgnoreCase(parceiro.getRaca())) && 
           (this.energia >= 80 && parceiro.getEnergia() >= 80)){
            return true;
        }
        return false;
    }
    
    public int cruzar(Cachorro parceiro){
        if(podeCruzar(parceiro)){
            setEnergia(getEnergia() - 50);
            parceiro.setEnergia(getEnergia() - 50);
            
            Random numeroFilhotes = new Random();
            int totalFilhotes = numeroFilhotes.nextInt(10) + 3;
            setFilhotes(totalFilhotes);
           parceiro.setFilhotes(totalFilhotes);
           System.out.println(totalFilhotes);
           return totalFilhotes;
        }else{
            System.out.println("Não foi possivel fazer o cruzamento!");
            return -1;
        }
    }
}
