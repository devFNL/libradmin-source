function selectUserEdit() {
  const table = document.querySelector("#usersTable");

  for (let i = 1; i < table.rows.length; i++) {
    table.rows[i].onclick = function () {
      document.querySelector("#editUserId").value = this.cells[0].innerHTML;
      document.querySelector("#editUserName").value = this.cells[1].innerHTML;
      document.querySelector("#editUserLast").value = this.cells[2].innerHTML;
      document.querySelector("#editPhone").value = this.cells[3].innerHTML;
      document.querySelector("#editEmail").value = this.cells[4].innerHTML;
      document.querySelector("#editPass").value = this.cells[5].innerHTML;
      const activeValue = this.cells[6].innerHTML;
      document.querySelector("#editUserActive").value = activeValue;

      const editUserModal = new bootstrap.Modal(
        document.querySelector("#editUserModal")
      );
      editUserModal.show();
    };
  }
}

// function selectDelete() {
//   const table = document.querySelector("#usersTable");

//   for (let i = 1; i < table.rows.length; i++) {
//     table.rows[i].onclick = function () {
//       document.querySelector("#deleteId").value = this.cells[0].innerHTML;
//       document.querySelector("#deleteUserName").value = this.cells[1].innerHTML;
//       document.querySelector("#deleteLastName").value = this.cells[2].innerHTML;
//       document.querySelector("#deletePhone").value = this.cells[3].innerHTML;
//       document.querySelector("#deleteEmail").value = this.cells[4].innerHTML;
//       document.querySelector("#deletePass").value = this.cells[5].innerHTML;
//     };
//   }
// }
