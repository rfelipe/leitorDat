import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.io.*;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {


        try {
            String arquivoFonte = "dados/out/resolvido.dat";//Nome do arquivo de saida
            PrintWriter saida = new PrintWriter(new FileWriter(arquivoFonte));

            String linha;
            int line = 0;
            int contaCliente=0;
            int contaVendedores=0;
            String idvenda="";
            String nomevendedor="";

            ArrayList<String> dados = new ArrayList();

            //verifica os arquivos na pasta dados/in
            File arquivos[];
            File diretorio = new File("dados/in/");
            arquivos = diretorio.listFiles();

            //faz a leitura de todos os arquivos na pasta
            for(int i = 0; i < arquivos.length; i++) {
                FileReader reader = new FileReader(arquivos[i]);
                BufferedReader leitor = new BufferedReader(reader);

                //passa os dados de todos os arquivos apra uma lista
                while ((linha = leitor.readLine()) != null) {
                    dados.add(linha);
                    line++;
                }
            }


            //contadores cliente e vendedor
            int n = dados.size();
            for (int x=0; x<n; x++) {
                if(dados.get(x).substring(0,3).equals("002")){
                    contaCliente++;
                }
                if(dados.get(x).substring(0,3).equals("001")){
                    contaVendedores++;
                }
            }
            float maior=0;
            float menor=0;
            for (int i=0;i<dados.size();i++) {
                if(dados.get(i).substring(0,3).equals("003")){
                    float valor = Float.parseFloat(dados.get(i).substring(17,24));
                    if (valor>maior){
                        maior=valor;
                       idvenda= dados.get(i).substring(4,6);
                    }
                }
            }
           int tamanho= dados.size();
            for (int i=0;i<dados.size();i++) {

                if(dados.get(i).substring(0,3).equals("003")){
                    float valor = Float.parseFloat(dados.get(i).substring(17,24));
                    menor=valor;

                    if (menor<=valor){
                        menor=valor;
                        nomevendedor= dados.get(i).substring(25);

                    }
                }
            }

            saida.write("1 - Quantidade de Clientes: "+ contaCliente);
            saida.println();
            //saida.write(linha +" Vendedor" );
            saida.write("2 - Quantidade de Vendedores: "+ contaCliente);
            saida.println();
            saida.write("3 - ID da Venda de valor mais alto: "+ idvenda);
            saida.println();
            saida.write("4 - Nome do Vendedor que menos vendeu: "+ nomevendedor);
            saida.println();

            saida.close();
//            leitor.close();
//            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}