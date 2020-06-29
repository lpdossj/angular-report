package br.estudos.ngreport.controller;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.estudos.ngreport.bean.Produto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Service
public class RelatorioService {

	public List<Produto> listarProdutos() {
		List<Produto> lista = new ArrayList<Produto>();
		
		for (int i = 0; i < 100; i++) {
			lista.add(createProduto(i));
		}
		return lista;
	}
	
	private BigDecimal random(int casasInt, int casasDec) {
		Random r = new Random();
		double valor = r.nextDouble();
		int multiplicador = r.nextInt(casasInt);
		valor = Math.pow(10, multiplicador) * valor;

		return new BigDecimal(String.valueOf(valor)).setScale(casasDec, RoundingMode.HALF_UP);
	}
	
	private Produto createProduto(int i) {
		Produto produto = new Produto(i + 1L, "Nome " + (i+1), random(5, 2));
		Random r = new Random();
		int intRandom = r.nextInt(100) % 3;
		
		switch (intRandom) {
		case 0:
			produto.setStatus("ATIVO");
			break;
		case 1:
			produto.setStatus("INATIVO");
			break;
		case 2:
			produto.setStatus("PENDENTE");
			break;
		default:
			produto.setStatus("DESCONHECIDO");
			break;
		}
		
		intRandom = r.nextInt(100) % 3;
		
		switch (intRandom) {
		case 0:
			produto.setTipoProduto("ELETRONICO");
			break;
		case 1:
			produto.setTipoProduto("CAMA E MESA");
			break;
		case 2:
			produto.setTipoProduto("PERECÍVEL");
			break;
		default:
			produto.setTipoProduto("NÃO CATALOGADO");
			break;
		}
		
		return produto;
	}

	public JasperPrint criarRelatorioProdutos() throws JRException {
		// Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/relatorios/relatorio_produto.jrxml");
 
        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);
 
        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(listarProdutos());
 
        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("LT", "110.120.77");
 
        // Filling the report with the employee data and additional parameters information.
        JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
        
        return print;
	}
	
	public void criarRelatorioProdutosLocal() throws JRException {
		// Fetching the .jrxml file from the resources folder.
        final InputStream stream = this.getClass().getResourceAsStream("/relatorios/relatorio_produto.jrxml");
 
        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);
 
        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(listarProdutos());
 
        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("LT", "110.120.77");
 
        // Filling the report with the employee data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
 
        // Users can change as per their project requrirements or can take it as request input requirement.
        // For simplicity, this tutorial will automatically place the file under the "c:" drive.
        // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.
        final String filePath = "./";
        // Export the report to a PDF file.
        JasperExportManager.exportReportToPdfFile(print, filePath + "Employee_report.pdf");
        
		
	}
}
