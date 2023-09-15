var currentUrl = window.location.pathname;

var urlToLinkIdMap = {
  "/": "home-link",
  "/userList": "user-list-link",
  "/newUser": "new-user-link",
  "/bookList": "books-list-link",
  "/newBook": "new-book-link",
};

var linkId = urlToLinkIdMap[currentUrl];

if (linkId) {
  var linkElement = document.getElementById(linkId);
  if (linkElement) {
    linkElement.classList.add("active");
  }
}
