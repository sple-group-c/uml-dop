module BeritaBoardVM.beritaboard.core {
	exports BeritaBoardVM.beritaboard;
	exports BeritaBoardVM.beritaboard.core.model;
	exports BeritaBoardVM.beritaboard.core.resource;
	exports BeritaBoardVM.beritaboard.core.service;
	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens BeritaBoardVM.beritaboard to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
	opens BeritaBoardVM.beritaboard.core.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
