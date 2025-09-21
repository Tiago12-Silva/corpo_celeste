abstract class CorpoCeleste {
    protected String nome;
    protected String localizacao;
    protected boolean produzLuzPropria;
    protected double massa; 
    protected double diametro; 
    protected String composicao;
    protected String orbita;

    public CorpoCeleste(String nome, String localizacao, boolean produzLuzPropria,
                        double massa, double diametro, String composicao, String orbita) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.produzLuzPropria = produzLuzPropria;
        this.massa = massa;
        this.diametro = diametro;
        this.composicao = composicao;
        this.orbita = orbita;
    }

    public void imprimirInfo() {
        System.out.println("\n=== " + nome + " ===");
        System.out.println("Localização: " + localizacao);
        System.out.println("Produz luz própria: " + produzLuzPropria);
        System.out.println("Massa: " + massa + " kg");
        System.out.println("Diâmetro: " + diametro + " km");
        System.out.println("Composição: " + composicao);
        System.out.println("Órbita: " + orbita);
    }
}


class Planeta extends CorpoCeleste {
    private int quantidadeLuas;
    private boolean temAneis;
    private boolean temVida;
    private String sistema;

    public Planeta(String nome, String localizacao, double massa, double diametro,
                   String composicao, String orbita, int quantidadeLuas,
                   boolean temAneis, boolean temVida, String sistema) {
        super(nome, localizacao, false, massa, diametro, composicao, orbita);
        this.quantidadeLuas = quantidadeLuas;
        this.temAneis = temAneis;
        this.temVida = temVida;
        this.sistema = sistema;
    }

    @Override
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("Quantidade de luas: " + quantidadeLuas);
        System.out.println("Tem anéis: " + temAneis);
        System.out.println("Tem vida: " + temVida);
        System.out.println("Sistema: " + sistema);
    }
}


class Estrela extends CorpoCeleste {
    private String tipoEspectral;
    private double luminosidade; 
    private String estagioEvolutivo;
    private String tipo;
    private double temperatura; 

    public Estrela(String nome, String localizacao, double massa, double diametro,
                   String composicao, String orbita, String tipoEspectral,
                   double luminosidade, String estagioEvolutivo,
                   String tipo, double temperatura) {
        super(nome, localizacao, true, massa, diametro, composicao, orbita);
        this.tipoEspectral = tipoEspectral;
        this.luminosidade = luminosidade;
        this.estagioEvolutivo = estagioEvolutivo;
        this.tipo = tipo;
        this.temperatura = temperatura;
    }

    public void atualizarTipo() {
        if (massa < 0.5) {
            tipo = "Anã Vermelha";
        } else if (massa < 1.4) {
            tipo = "Anã Branca";
        } else if (massa < 3) {
            tipo = "Estrela de Massa Intermediária";
        } else {
            tipo = "Estrela Massiva";
        }
    }

    public void imprimirTempoDeVida() {
        double vida = 1e10 / massa; 
        System.out.println(nome + " ainda viverá aproximadamente " + vida + " bilhões de anos.");
    }

    @Override
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("Tipo espectral: " + tipoEspectral);
        System.out.println("Luminosidade (em solares): " + luminosidade);
        System.out.println("Estágio evolutivo: " + estagioEvolutivo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Temperatura: " + temperatura + " K");
    }
}


class Asteroide extends CorpoCeleste {
    private String tipoOrbital;
    private String grupoOrbital;
    private boolean perigoso;

    public Asteroide(String nome, String localizacao, double massa, double diametro,
                     String composicao, String orbita, String tipoOrbital,
                     String grupoOrbital) {
        super(nome, localizacao, false, massa, diametro, composicao, orbita);
        this.tipoOrbital = tipoOrbital;
        this.grupoOrbital = grupoOrbital;
        this.perigoso = false;
    }

    public void verificarPerigo() {
        if (diametro > 140 && massa > 1e10) { 
            perigoso = true;
            System.out.println("⚠ ALERTA: O asteroide " + nome + " é potencialmente perigoso para a Terra!");
        }
    }

    @Override
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("Tipo orbital: " + tipoOrbital);
        System.out.println("Grupo orbital: " + grupoOrbital);
        System.out.println("Perigoso: " + perigoso);
    }
}


public class Main {
    public static void main(String[] args) {
      
        Planeta terra = new Planeta("Terra", "Via Láctea", 5.97e24, 12742,
                "Rochas, Metais", "Órbita do Sol", 1, false, true, "Sistema Solar");
        Planeta jupiter = new Planeta("Júpiter", "Via Láctea", 1.90e27, 139820,
                "Gases", "Órbita do Sol", 79, true, false, "Sistema Solar");

        
        Estrela sol = new Estrela("Sol", "Via Láctea", 1.0, 1392684,
                "Hidrogênio, Hélio", "Centro do Sistema Solar", "G2V",
                1.0, "Sequência Principal", "Anã Amarela", 5778);
        Estrela sirius = new Estrela("Sirius A", "Via Láctea", 2.02, 1714000,
                "Hidrogênio, Hélio", "Órbita Binária", "A1V",
                25.4, "Sequência Principal", "Estrela de Massa Intermediária", 9940);

        Asteroide apophis = new Asteroide("Apophis", "Via Láctea", 2.7e10, 370,
                "Rochas, Níquel", "Órbita próxima à Terra", "Apollo", "NEO");
        Asteroide ceres = new Asteroide("Ceres", "Cinturão de Asteroides", 9.4e20, 940,
                "Rochas, Gelo", "Entre Marte e Júpiter", "Cinturão Principal", "Asteroide");

        terra.imprimirInfo();
        jupiter.imprimirInfo();

        sol.atualizarTipo();
        sol.imprimirInfo();
        sol.imprimirTempoDeVida();

        sirius.atualizarTipo();
        sirius.imprimirInfo();
        sirius.imprimirTempoDeVida();

        apophis.verificarPerigo();
        apophis.imprimirInfo();

        ceres.verificarPerigo();
        ceres.imprimirInfo();
    }
}
