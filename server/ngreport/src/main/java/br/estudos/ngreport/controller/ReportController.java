package br.estudos.ngreport.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.estudos.ngreport.bean.Produto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private RelatorioService service;
	
	@GetMapping
	public List<Produto> lista() {
		return service.listarProdutos();
	}
	
	@GetMapping("/produtos")
	public ModelAndView relatorioProdutos() {
		ModelAndView model = new ModelAndView("/report");
		
		try {
			service.criarRelatorioProdutos();
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	@GetMapping("/download/produtos")
	public void relatorioProdutosPost(ModelAndView model, HttpServletResponse response) throws JRException, IOException {
	  JasperPrint jasperPrint = null;

	  //response.setContentType("application/x-download");
	  response.setContentType("application/pdf");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"report_produtos.pdf\""));

	  OutputStream out = response.getOutputStream();
	  jasperPrint = service.criarRelatorioProdutos();
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}
}
