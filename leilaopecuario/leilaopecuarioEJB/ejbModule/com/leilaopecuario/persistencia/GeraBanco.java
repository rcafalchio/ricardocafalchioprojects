package com.leilaopecuario.persistencia;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraBanco {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// EntityManager manager = new JPAUtil().createEntityManager();
			// manager.close();
			AnnotationConfiguration configuration = new AnnotationConfiguration();
			configuration.configure();
			new SchemaExport(configuration).create(true, true);
			System.out.println("Gerou o banco com sucesso");
		} catch (Exception e) {
			System.err.println("Problemas ao gerar o banco");
			System.err.println(e.getMessage());
		}
	}

}
