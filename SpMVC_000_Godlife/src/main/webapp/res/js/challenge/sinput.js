document.addEventListener("DOMContentLoaded", () => {
  const INDEX = {
    CODE: 0,
    TITLE: 1,
    WRITE: 2,
    START: 3,
    END: 4,
    DETAIL: 5,
  };
  const form_sinput =
    document.querySelector("form.main.sinput") ||
    document.querySelector("form.main.supdate");

  const sinput_code = form_sinput?.querySelector("input[name='s_code']");

  const sinput_stitle = document.querySelector("input[name='s_title']");
  const sinput_swrite = document.querySelector("input[name='s_write']");
  const sinput_sstart = document.querySelector("input[name='s_start']");
  const sinput_send = document.querySelector("input[name='s_end']");
  const sinput_sdetail = document.querySelector("input[name='s_detail']");

  const btn_sinput = document.querySelector("button.sinput");

  const msg_boxs = document.querySelectorAll("div.message");

  const message_view = (index, className, message) => {
    const msg_box = msg_boxs[index];
    msg_box?.classList.remove("ok");
    msg_box?.classList.remove("error");

    msg_box?.classList.add(className);
    msg_box.querySelector("span").innerHTML = message;
  };

  const sinputButtonClickHandler = (e) => {
    for (let i = 0; i < msg_boxs.length; i++) {
      msg_boxs[i].classList.remove("ok");
      msg_boxs[i].classList.remove("error");
    }

    if (confirm("저장할까요?")) {
      form_sinput?.submit();
    }
  };
  btn_sinput?.addEventListener("click", sinputButtonClickHandler);
});
