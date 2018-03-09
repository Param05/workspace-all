package bookapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bookapp.model.persistance.Book;
import bookapp.model.service.BookService;

@RequestMapping(value = "/")
public class BookAppController {

	@Autowired
	private BookService service;

	@RequestMapping(value = "viewAll", method = RequestMethod.GET)
	public ModelAndView viewAll() {
		ModelAndView m = new ModelAndView();
		m.setViewName("showAllbooks");
		m.addObject("books", service.getAllBooks());
		return m;
	}

	@RequestMapping(value = "addBook", method = RequestMethod.GET)
	public String showBookForm(ModelMap map) {
		Book book = new Book();
		map.addAttribute("book", book);
		return "bookform";
	}

	@RequestMapping(value = "addBook", method = RequestMethod.POST)
	public String submittedBookForm(@Valid Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "bookform";
		} else {
			service.addBook(book);
			return "redirect:viewAll";
		}
	}

	
}
