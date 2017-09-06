import AnimalGame from './view/AnimalGame.vue'
import Frame from './view/IFrame.vue'
import MarkDown from './view/MarkDown.vue'
import ImageUpload from './view/image/ImageUpload.vue'
import Gallery from './view/image/Gallery.vue'

const routes = [
    {name: 'animalGame', path: '/animalGame', component: AnimalGame},
    {name: 'frame', path: '/frame/:scheme/:host/:port', component: Frame},
    {name: 'markDown', path: '/markDown', component: MarkDown},
    {name: 'imageUpload', path: '/image/upload', component: ImageUpload},
    {name: 'gallery', path: '/image/list', component: Gallery},
];

export default routes;