document.addEventListener("DOMContentLoaded", () => {
  const msg_divs = document.querySelectorAll("div.msg_div");

  document.querySelector("#login")?.addEventListener("click", async (e) => {
    const input_id = document.querySelector("input#email");
    const input_pw = document.querySelector("input#password");
    // console.log(input_id);
    if (!input_id.value) {
      const nav_text = "* 이메일을 입력해주세요";
      msg_divs[1].style.display = "none";
      msg_divs[0].style.display = "block";
      msg_divs[0].textContent = nav_text;
      msg_divs[0].style.color = "tomato";
      return false;
    }
    if (!input_pw.value) {
      const nav_text = "* 비밀번호를 입력해주세요";
      msg_divs[0].style.display = "none";
      msg_divs[1].style.display = "block";
      msg_divs[1].textContent = nav_text;
      msg_divs[1].style.color = "tomato";
      return false;
    }

    const idcheck_url = `${rootPath}/member/login_check?u_email=${input_id.value}&u_password=${input_pw.value}`;
    const respnse = await fetch(idcheck_url);
    const result = await respnse.text();
    // console.log(respnse);
    // console.log(result);
    if (result === "EXIST") {
      const nav_text = "* 가입된 이메일이 없습니다";
      msg_divs[1].style.display = "none";
      msg_divs[0].style.display = "block";
      msg_divs[0].textContent = nav_text;
      msg_divs[0].style.color = "tomato";
      input_id.focus();
      return false;
    } else if (result === "WRONGPW") {
      const nav_text = "* 비밀번호가 다릅니다";
      msg_divs[0].style.display = "none";
      msg_divs[1].style.display = "block";
      msg_divs[1].textContent = nav_text;
      msg_divs[1].style.color = "tomato";
      input_pw.focus();
      return false;
    } else if (result === "YES") {
      msg_divs[0].style.display = "none";
      msg_divs[1].style.display = "none";
      document.location.href = `${rootPath}/challengeTest`;
      // alert("통과");
    } else {
      msg_divs[0].style.display = "none";
      msg_divs[1].style.display = "none";
      alert("ERROR");
    }
  });

  // input_id?.addEventListener("blur", async (e) => {
  //   const value = e.target.value;
  //   // const span_box = msg_box.querySelector("span");
  //   const idcheck_url = `${rootPath}/id_check?id=${value}`;

  //   if (!value) {
  //     message_view(INDEX.ID, "error", "* ID를 입력해주세요.");
  //     input_id.focus();
  //     return false;
  //   }

  //   const respnse = await fetch(idcheck_url);
  //   const result = await respnse.text();
  //   if (result === "OK") {
  //     message_view(INDEX.ID, "ok", "* 사용가능한 ID 입니다");
  //   } else if (result === "FAIL") {
  //     message_view(INDEX.ID, "error", "* 사용중인 ID 입니다");
  //     input_id.focus();
  //   } else {
  //     message_view(INDEX.ID, "error", "* 서버오류!");
  //     input_id.focus();
  //   }
  // });
});
