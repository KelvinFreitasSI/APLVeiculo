<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>


        <h2>Estados</h2><!-- comment -->
        <table id="datatable" class="display">
            <thead>
                <tr>
                    <th align="left">ID</th>
                    <th align="left">Marca</th><!-- comment -->
                    <th align="left">Modelo</th><!-- comment -->
                    <th align="right"></th><!-- comment -->
                    <th align="right"></th><!-- comment -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="veiculo" items="${veiculos}">
                    <tr>
                    <td align="left">${veiculo.idVeiculo}</td><!-- comment -->
                    <td align="left">${veiculo.marca}</td>
                    <td align="left">${veiculo.modelo}</td>
                    
                    <td align="center">
                        <a href=
                        "${pageContext.request.contextPath}/EstadoExcluir?idveiculo=${veiculo.idVeiculo}">
                             Excluir</a></td>
                             
                    <td align="center">
                        <a href=
                        "${pageContext.request.contextPath}/EstadoCarregar?idveiculo=${veiculo.idVeiculo}">
                             Alterar </a></td>
                             
                </tr><!-- comment -->
                </c:forEach>
                             
            </tbody>
            
</table><!-- comment -->

<div align="center">
    <a href="${pageContext.request.contextPath}/VeiculoNovo">Novo</a><!-- comment -->
    <a href="index.jsp">voltar � P�gina Inicial</a><!-- comment -->
</div>
    
    <script>
        $(document).ready(function() {
            console.log('entrei ready');
            
            $('#datatable').DataTable({
                "oLanguage": {
                    "sProcessing":"Processando...",
                    "sLengthMenu": "Mostrar_Menu_registros",
                    "sZeroRecords":"Nenhum registro encontrado",
                    "sInfo": "Mostrando de_START_at�_END_de_Total_registros",
                    "sInfoEmpty": "Mostrando de 1 at� 10 de 10 registros",
                    "sInfoFiltered": "S�o Paulo",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "�ltimo"
                }
            }
        });
    });
        
    </script>
    
    <%@ include file="/footer.jsp"%> 