function selectBookEdit() {
  const table = document.querySelector("#booksTable");

  for (let i = 1; i < table.rows.length; i++) {
    table.rows[i].onclick = function () {
      document.querySelector("#editBookId").value = this.cells[0].innerHTML;
      document.querySelector("#editISBN").value = this.cells[1].innerHTML;
      document.querySelector("#editTitle").value = this.cells[2].innerHTML;
      document.querySelector("#editAuthor").value = this.cells[3].innerHTML;
      document.querySelector("#editPublisher").value = this.cells[4].innerHTML;
      document.querySelector("#editYear").value = this.cells[5].innerHTML;
      document.querySelector("#editCopies").value = this.cells[6].innerHTML;
      document.querySelector("#editBorrowedCopies").value =
        this.cells[7].innerHTML;
      document.querySelector("#editRemainingCopies").value =
        this.cells[8].innerHTML;
      const activeValue = this.cells[9].innerHTML;
      document.querySelector("#editBookActive").value = activeValue;

      const editBookModal = new bootstrap.Modal(
        document.querySelector("#editBookModal")
      );
      editBookModal.show();
    };
  }
}
