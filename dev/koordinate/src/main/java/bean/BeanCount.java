package bean;

    //<editor-fold defaultstate="collapsed" desc="importacoes">
import dao.DAOComponenteCurricular;
import dao.DAOConcurso;
import dao.DAOCurso;
import dao.DAODocente;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//</editor-fold>

/**
 * Classe responsável por gerenciar os contadores do menu principal
 *
 * @author Eduardo Amaral
 */
@RequestScoped
@ManagedBean(name = "beanCount")
public class BeanCount {

    //<editor-fold defaultstate="collapsed" desc="variaveis">
    private int countComp;
    private int countDoc;
    private int countCur;
    private int countConc;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="construct e init">
    /** Método Construtor
     *
     */
    public BeanCount() {
    }
    
    /**
     * Método init responsável por iniciar as variáveis da classe
     *
     */
    @PostConstruct
    public void init() {
        this.countComp = DAOComponenteCurricular.count();
        this.countDoc = DAODocente.count();
        this.countCur = DAOCurso.count();
        this.countConc = DAOConcurso.count();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters e setters">
    /** Método responsável por recuperar o valor de countCur
     *
     * @return A quantidade de registros do tipo Curso
     */
    public int getCountCur() {
        return countCur;
    }
    
    /** Método responsável por por recuperar o valor de countComp
     *
     * @return A quantidade de registros de Componentes Curriculares
     */
    public int getCountComp() {
        return countComp;
    }
    
    /** Método responsável por recuperar o valor de countDoc
     *
     * @return A quantidade de registros do tipo Docente
     */
    public int getCountDoc() {
        return countDoc;
    }
    
    /** Método responsável por recuperar o valor de countConc
     *
     * @return A quantidade de registros do tipo Concurso
     */
    public int getCountConc() {
        return countConc;
    }
//</editor-fold>
}
