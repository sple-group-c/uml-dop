module LabelVM.label.core {
	exports LabelVM.label;
	exports LabelVM.label.core.model;
	exports LabelVM.label.core.resource;
	exports LabelVM.label.core.service;
	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens LabelVM.label to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
	opens LabelVM.label.core.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
