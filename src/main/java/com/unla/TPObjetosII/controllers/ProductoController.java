	@GetMapping("/actualizar")
	public ModelAndView actualizarProducto() {
		ModelAndView mAV =new ModelAndView(ViewRouteHelper.PRODUCTO_ACTUALIZAR);
		List<Producto> productos = new ArrayList<Producto>();
		productos = productoService.getAll();
		mAV.addObject("productos",productos);
		return mAV;
	}
