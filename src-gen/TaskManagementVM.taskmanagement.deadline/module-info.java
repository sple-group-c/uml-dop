module TaskManagementVM.taskmanagement.deadline {
	requires TaskManagementVM.taskmanagement.core;
	exports TaskManagementVM.taskmanagement.deadline.model;
	exports TaskManagementVM.taskmanagement.deadline.resource;
	exports TaskManagementVM.taskmanagement.deadline.service;

	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens TaskManagementVM.taskmanagement.deadline.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
