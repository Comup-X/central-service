import AnimalGame from './view/AnimalGame.vue'
import Frame from './view/IFrame.vue'
import MarkDown from './view/MarkDown.vue'
import ImageUpload from './view/image/ImageUpload.vue'
import Gallery from './view/image/Gallery.vue'
import Report from './view/Report.vue'
import Index from './view/Index.vue'
import NotFound from './view/NotFound.vue'

const routes = [
    {name: 'animalGame', path: '/animalGame', component: AnimalGame},
    {name: 'frame', path: '/frame/:scheme/:host/:port', component: Frame},
    {name: 'markDown', path: '/markDown', component: MarkDown},
    {name: 'imageUpload', path: '/image/upload', component: ImageUpload},
    {name: 'gallery', path: '/image/list', component: Gallery},
    {name: 'report', path: '/report', component: Report},
    {name: 'index', path: '/index', component: Index},
    {name: 'index', path: '/', component: Index},
    {name: '404', path: '/404', component: NotFound},
];

export default routes;