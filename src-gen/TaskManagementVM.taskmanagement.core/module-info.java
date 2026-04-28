module TaskManagementVM.taskmanagement.core {
	exports TaskManagementVM.taskmanagement;
	exports TaskManagementVM.taskmanagement.core.model;
	exports TaskManagementVM.taskmanagement.core.resource;
	exports TaskManagementVM.taskmanagement.core.service;
	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens TaskManagementVM.taskmanagement to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
	opens TaskManagementVM.taskmanagement.core.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
