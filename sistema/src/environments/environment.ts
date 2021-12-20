const API_BASE_TALLERES = 'http://localhost:8081/taller-service/';
const API_BASE_TALLERES_RESOURCES = 'https://www.munisantanita.gob.pe/data/talleres/';

export const environment = {
  production: false,
  API_BASE_TALLERES,
  API_SECCIONES: API_BASE_TALLERES + 'secciones',
  API_TALLERES: API_BASE_TALLERES + 'talleres',
  API_SANGUINEOS: API_BASE_TALLERES + 'sanguineos',
  API_SEGUROS: API_BASE_TALLERES + 'seguros',
  API_ESTUDIANTES: API_BASE_TALLERES + 'estudiantes',
  API_APODERADOS: API_BASE_TALLERES + 'apoderados',
  API_MATRICULAS: API_BASE_TALLERES + 'matriculas',
  API_UBIGEO: API_BASE_TALLERES + 'ubigeo',
  API_CATEGORIAS: API_BASE_TALLERES + 'categorias',
  API_TRANSACCIONES: API_BASE_TALLERES + 'transacciones',
  API_INSCRITOS: API_BASE_TALLERES + 'inscripciones',
  API_RESOURCE_IMAGE_DEFAULT: API_BASE_TALLERES_RESOURCES + 'cursos/curso-default.jpg',
  API_RESOURCE_IMAGE: API_BASE_TALLERES_RESOURCES + 'cursos/',
  API_TALLERES_FIND: API_BASE_TALLERES + 'talleres/findx',
  API_EDADES: API_BASE_TALLERES + 'edades',
  API_TEMPORADAS: API_BASE_TALLERES + 'temporadas',
  API_HORAS: API_BASE_TALLERES + 'horas',
  API_DIAS: API_BASE_TALLERES + 'dias',
  API_LUGARES: API_BASE_TALLERES + 'lugares',

  API_NIUBIZ_SECURITY: 'https://apisandbox.vnforappstest.com/api.security/v1/security',
  API_NIUBIZ_SESSION: 'https://apitestenv.vnforapps.com/api.ecommerce/v2/ecommerce/token/session',
  API_NIUBIZ_IDCOMERCIO: '602545705',
  API_PAGOSENLINEA_TRANSACCION: 'http://localhost:8080/pagosenlinea-transaccion',
  API_NIUBIZ_CREDENCIAL: 'aW50ZWdyYWNpb25lcy52aXNhbmV0QG5lY29tcGx1cy5jb206ZDVlN25rJE0='

};
