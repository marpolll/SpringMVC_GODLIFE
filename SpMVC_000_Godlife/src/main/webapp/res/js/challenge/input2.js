document.addEventListener("DOMContentLoaded", () => {
  const INDEX = {
    CODE: 0,
    TITLE: 1,
    WRITE: 2,
    START: 3,
    END: 4,
    COUNT: 5,
    DETAIL: 6,
  };
  const form_coinput = document.querySelector("form.main.coinput");

  const cinput_seq = form_coinput?.querySelector("input[name='c_seq']");

  const cinput_ctitle = document.querySelector("input[name='c_title']");
  const cinput_cwrite = document.querySelector("input[name='c_write']");
  const cinput_cstart = document.querySelector("input[name='c_start']");
  const cinput_cend = document.querySelector("input[name='c_end']");
  const cinput_ccount = document.querySelector("input[name='c_count']");
  const cinput_cdetail = document.querySelector("input[name='c_detail']");

  const btn_coinput = document.querySelector("button.coinput");

  const msg_boxs = document.querySelectorAll("div.message");

  const message_view = (index, className, message) => {
    const msg_box = msg_boxs[index];
    msg_box?.classList.remove("ok");
    msg_box?.classList.remove("error");

    msg_box?.classList.add(className);
    msg_box.querySelector("span").innerHTML = message;
  };

  const cinputButtonClickHandler = (e) => {
    for (let i = 0; i < msg_boxs.length; i++) {
      msg_boxs[i].classList.remove("ok");
      msg_boxs[i].classList.remove("error");
    }

    if (confirm("저장할까요?")) {
      form_coinput?.submit();
    }
  };
  btn_coinput?.addEventListener("click", cinputButtonClickHandler);
});
