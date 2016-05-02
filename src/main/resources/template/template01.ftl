<html>
<head><title> ${blogTitle} </title>
<body>
<h1> ${blogTitle} </h1>
<p>
  ${message}
</p>
<h3>References</h3>
<#list references as reference>
    ${reference_index + 1}. <a href="${reference}"> ${reference} </a> <br/>
</#list>
</body>
</html> 