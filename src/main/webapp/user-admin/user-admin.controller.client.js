(function () {
    var $usernameFld, $passwordFld;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn;
    var $userRowTemplate, $tbody;
    var users = []
    var selectedUser = null
    // var userService = new AdminUserServiceClient();
    $(main);

        function main() {
            $usernameFld = $("#usernameFld")
            $passwordFld = $("#passwordFld")
            $firstNameFld = $("#firstNameFld")
            $lastNameFld = $("#lastNameFld")
            $roleFld = $("#roleFld")
            $createBtn = $(".wbdv-create")
            $updateBtn = $(".wbdv-update")
            $tbody = $("tbody")

            $updateBtn.click(updateUser)

            $createBtn.click(() => {
                createUser({
                    username: $usernameFld.val(),
                    password: $passwordFld.val(),
                    firstName: $firstNameFld.val(),
                    lastName: $lastNameFld.val(),
                    role: $roleFld.val(),
                })
                $usernameFld.val("")
                $passwordFld.val("")
                $firstNameFld.val("")
                $lastNameFld.val("")
                $roleFld.val("FACULTY")
            })

        }
        function createUser(user) {
              users.push(user)
              renderUsers(users)
        }
        function deleteUser(event) {
            var deleteBtn = jQuery(event.target)
            var theClass = deleteBtn.attr("class")
            var theIndex = deleteBtn.attr("id")
            var theId = users[theIndex]._id

            users.splice(theIndex, 1)
            renderUsers(users)
        }
        function selectUser(event) {
          var selectBtn = jQuery(event.target)
          console.log(selectBtn)
          var theIndex = selectBtn.attr("id")
          var theId = users[theIndex]._id
          selectedUser = users.find(user => user._id === theId)

          $usernameFld.val(selectedUser.username)
          $passwordFld.val(selectedUser.password)
          $firstNameFld.val(selectedUser.firstName)
          $lastNameFld.val(selectedUser.lastName)
          $roleFld.val(selectedUser.role)
        }
       function updateUser() {
          selectedUser.username = $usernameFld.val()
          selectedUser.password = $passwordFld.val()
          selectedUser.firstName = $firstNameFld.val()
          selectedUser.lastName = $lastNameFld.val()
          selectedUser.role = $roleFld.val()

          var index = users.findIndex(user => user._id === selectedUser._id)
          users[index] = selectedUser
          renderUsers(users)

          $usernameFld.val("")
          $passwordFld.val("")
          $firstNameFld.val("")
          $lastNameFld.val("")
          $roleFld.val("FACULTY")

       }
        function renderUsers(users) {
            $tbody.empty()
              for (var i = 0; i < users.length; i++) {
                var user = users[i]
                $tbody
                  .prepend(`
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.role}</td>
                    <td>
                        <i class="fa-2x fa fa-times wbdv-delete" id="${i}"></i>
                        <i class="fa-2x fa fa-pencil wbdv-select" id="${i}"></i>
                    </td>
                </tr>
              `)
              }
              jQuery(".wbdv-delete")
                .click(deleteUser)
              jQuery(".wbdv-select")
                .click(selectUser)

        }
//        function findAllUsers() { … } // optional - might not need this
//        function findUserById() { … } // optional - might not need this
    })();
