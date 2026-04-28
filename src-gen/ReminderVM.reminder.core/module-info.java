module ReminderVM.reminder.core {
	exports ReminderVM.reminder;
	exports ReminderVM.reminder.core.model;
	exports ReminderVM.reminder.core.resource;
	exports ReminderVM.reminder.core.service;
	requires id.ac.ui.cs.prices.winvmj.core;
	requires id.ac.ui.cs.prices.winvmj.hibernate;
	requires id.ac.ui.cs.prices.winvmj.auth;
	requires java.logging;
	// https://stackoverflow.com/questions/46488346/error32-13-error-cannot-access-referenceable-class-file-for-javax-naming-re/50568217
	requires java.naming;
	requires java.net.http;

	opens ReminderVM.reminder to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
	opens ReminderVM.reminder.core.model to org.hibernate.orm.core, gson, id.ac.ui.cs.prices.winvmj.hibernate;
}
